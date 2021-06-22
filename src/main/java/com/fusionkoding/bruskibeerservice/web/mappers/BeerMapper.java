package com.fusionkoding.bruskibeerservice.web.mappers;

import com.fusionkoding.brewing.model.BeerDto;
import com.fusionkoding.bruskibeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    @Mapping(source = "beerName", target = "beerName")
    BeerDto beerToBeerDto(Beer beer);

    @Mapping(source = "beerName", target = "beerName")
    BeerDto beerToBeerDtoWithInventory(Beer beer);

    @Mapping(source = "beerName", target = "beerName")
    Beer beerDtoToBeer(BeerDto beerDto);
}
