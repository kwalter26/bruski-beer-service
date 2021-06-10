package com.fusionkoding.bruskibeerservice.events;


import com.fusionkoding.bruskibeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent{
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
