package com.fusionkoding.bruskibeerservice.services;

import java.util.UUID;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;

public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
