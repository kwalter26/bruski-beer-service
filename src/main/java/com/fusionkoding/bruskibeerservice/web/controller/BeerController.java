package com.fusionkoding.bruskibeerservice.web.controller;

import java.util.UUID;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import com.fusionkoding.bruskibeerservice.web.model.BeerPagedListDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/been")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {

        // TODO: implement get beer
        return ResponseEntity.ok(BeerDto.builder().build());
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {

        // TODO: implement save beer
        return ResponseEntity.ok(BeerDto.builder().build());
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        // TODO: implement update beer
        return ResponseEntity.ok(BeerDto.builder().build());
    }
}
