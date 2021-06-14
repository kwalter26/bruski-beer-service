package com.fusionkoding.bruskibeerservice.services.brewing;

import com.fusionkoding.bruskibeerservice.config.JmsConfig;
import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.events.BrewBeerEvent;
import com.fusionkoding.bruskibeerservice.events.NewInventoryEvent;
import com.fusionkoding.bruskibeerservice.repositories.BeerRepository;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(@Payload BrewBeerEvent brewBeerEvent) {
        BeerDto beerDto = brewBeerEvent.getBeerDto();
        Beer beer = beerRepository.getById(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }

}
