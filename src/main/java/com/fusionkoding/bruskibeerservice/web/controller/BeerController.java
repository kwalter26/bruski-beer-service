package com.fusionkoding.bruskibeerservice.web.controller;

import com.fusionkoding.bruskibeerservice.services.BeerService;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

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
