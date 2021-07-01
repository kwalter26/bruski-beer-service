package com.fusionkoding.bruskibeerservice.services.order;

import com.fusionkoding.brewery.model.ValidateBeerOrderRequest;
import com.fusionkoding.brewery.model.ValidateBeerOrderResponse;
import com.fusionkoding.bruskibeerservice.config.JmsConfig;
import com.fusionkoding.bruskibeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerService beerService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER)
    public void listen(@Payload ValidateBeerOrderRequest validateBeerOrderRequest) {
        log.debug("Received validation request: " + validateBeerOrderRequest.getBeerOrder().getId());
        Optional.ofNullable(validateBeerOrderRequest.getBeerOrder()).ifPresent(beerOrderDto -> Optional.ofNullable(beerOrderDto.getBeerOrderLines()).ifPresent(beerOrderLineDtos -> {
            boolean valid = beerOrderLineDtos.stream().anyMatch(beerOrderLineDto -> beerService.getByUpc(beerOrderLineDto.getUpc(), false) != null);
            jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESULT, ValidateBeerOrderResponse.builder().orderId(beerOrderDto.getId()).isValid(valid).build());
            log.debug("Validated request for: " + beerOrderDto.getId().toString());
        }));
    }
}
