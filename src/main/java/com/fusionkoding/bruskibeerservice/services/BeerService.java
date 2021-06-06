package com.fusionkoding.bruskibeerservice.services;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;

import java.util.UUID;
import java.util.List;

public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    List<BeerDto> getAllBeers();
}
