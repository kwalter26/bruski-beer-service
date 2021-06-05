package com.fusionkoding.bruskibeerservice.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fusionkoding.bruskibeerservice.bootstrap.BeerLoader;
import com.fusionkoding.bruskibeerservice.services.BeerService;
import com.fusionkoding.bruskibeerservice.web.controller.BeerController;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import com.fusionkoding.bruskibeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        when(beerService.getById(any())).thenReturn(validSavedBeer());

        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        when(beerService.saveNewBeer(any())).thenReturn(validSavedBeer());
        String beerDtoJson = objectMapper.writeValueAsString(validBeer());

        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        when(beerService.updateBeer(any(), any())).thenReturn(validSavedBeer());
        String beerDtoJson = objectMapper.writeValueAsString(validBeer());
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson)).andExpect(status().isNoContent());
    }

    private BeerDto validBeer() {
        return BeerDto.builder().beerName("Beer").beerStyle(BeerStyleEnum.IPA)
                .price(BigDecimal.valueOf(10.00)).upc(BeerLoader.BEER_1_UPC).build();
    }

    private BeerDto validSavedBeer() {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Beer").beerStyle(BeerStyleEnum.IPA)
                .price(BigDecimal.valueOf(10.00)).upc(BeerLoader.BEER_1_UPC).build();
    }

}
