package com.fusionkoding.bruskibeerservice.web.models;

import com.fusionkoding.bruskibeerservice.bootstrap.BeerLoader;
import com.fusionkoding.brewing.model.BeerDto;
import com.fusionkoding.brewing.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseTest {
    BeerDto getDto() {
        return BeerDto.builder().beerName("BeerName").beerStyle(BeerStyleEnum.ALE).id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now()).lastModifiedDate(OffsetDateTime.now()).price(new BigDecimal("12.99"))
                .upc(BeerLoader.BEER_1_UPC).build();
    }

    @Test
    void test() {
        assertNotNull(getDto());
    }

}
