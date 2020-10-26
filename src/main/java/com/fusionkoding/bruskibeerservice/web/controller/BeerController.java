package com.fusionkoding.bruskibeerservice.web.controller;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {

        // TODO: implement get beer
        return ResponseEntity.ok(BeerDto.builder().build());
    }

    @PostMapping
    public ResponseEntity<Object> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        BeerDto newBeer = BeerDto.builder().id(UUID.randomUUID()).build();
        // TODO: implement save beer
        return ResponseEntity.created(URI.create("/api/v1/beer/" + newBeer.getId().toString()))
                .body(BeerDto.builder().build());
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Object> updateBeerById(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        // TODO: implement update beer
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Object> deleteBeerById(@PathVariable UUID beerId) {
        // TODO: implement update beer
        return ResponseEntity.noContent().build();
    }
}
