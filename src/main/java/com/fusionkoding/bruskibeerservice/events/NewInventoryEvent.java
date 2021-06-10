package com.fusionkoding.bruskibeerservice.events;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
