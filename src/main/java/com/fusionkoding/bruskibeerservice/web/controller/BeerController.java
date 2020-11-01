package com.fusionkoding.bruskibeerservice.web.controller;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import com.fusionkoding.bruskibeerservice.services.BeerService;
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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return ResponseEntity.ok(beerService.getById(beerId));
    }

    @PostMapping
    public ResponseEntity<Object> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        BeerDto newBeer = beerService.saveNewBeer(beerDto);
        return ResponseEntity.created(URI.create("/api/v1/beer/" + newBeer.getId().toString()))
                .body(BeerDto.builder().build());
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Object> updateBeerById(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Object> deleteBeerById(@PathVariable UUID beerId) {
        return ResponseEntity.noContent().build();
    }
}
