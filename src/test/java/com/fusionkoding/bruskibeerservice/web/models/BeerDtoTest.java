package com.fusionkoding.bruskibeerservice.web.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fusionkoding.brewing.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
public class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.print(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"92b80b44-0a36-4a3e-88ba-fe06f253352e\",\"version\":null,\"createdDate\":\"2020-10-31T13:56:28-0500\",\"lastModifiedDate\":\"2020-10-31T13:56:28-0500\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123123123123,\"price\":\"12.99\",\"quantityOnHand\":null}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}
