package com.fusionkoding.bruskibeerservice.services;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import com.fusionkoding.bruskibeerservice.web.model.BeerPagedList;
import com.fusionkoding.bruskibeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}
