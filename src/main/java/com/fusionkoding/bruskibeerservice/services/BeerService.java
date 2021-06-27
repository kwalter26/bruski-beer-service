package com.fusionkoding.bruskibeerservice.services;

import com.fusionkoding.brewery.model.BeerDto;
import com.fusionkoding.brewery.model.BeerPagedList;
import com.fusionkoding.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId, boolean showBeerOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, boolean showInventoryOnHand);

    BeerDto getByUpc(String upc, boolean showBeerOnHand);
}
