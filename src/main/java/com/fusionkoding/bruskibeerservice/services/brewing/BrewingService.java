package com.fusionkoding.bruskibeerservice.services.brewing;

import com.fusionkoding.bruskibeerservice.config.JmsConfig;
import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.events.BrewBeerEvent;
import com.fusionkoding.bruskibeerservice.repositories.BeerRepository;
import com.fusionkoding.bruskibeerservice.services.inventory.BeerInventoryService;
import com.fusionkoding.bruskibeerservice.web.mappers.BeerMapper;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedDelay = 5000)
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if(beer.getMinOnHand()>=invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE,new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });

    }

}
