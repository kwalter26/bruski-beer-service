package com.fusionkoding.bruskibeerservice.web.mappers;

import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    @Mapping(source = "beerName", target = "beerName")
    BeerDto beerToBeerDto(Beer beer);

    @Mapping(source = "beerName", target = "beerName")
    Beer beerDtoToBeer(BeerDto beerDto);
}
