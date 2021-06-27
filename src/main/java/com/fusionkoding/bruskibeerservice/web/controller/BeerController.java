package com.fusionkoding.bruskibeerservice.web.controller;

import com.fusionkoding.brewery.model.BeerDto;
import com.fusionkoding.brewery.model.BeerPagedList;
import com.fusionkoding.brewery.model.BeerStyleEnum;
import com.fusionkoding.bruskibeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class BeerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerService beerService;

    @GetMapping(path = "/beer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeerPagedList> listBeers(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "beerName", required = false) String beerName,
            @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
            @RequestParam(value = "showInventoryOnHand", required = false, defaultValue = "false") boolean showInventoryOnHand
    ) {

        if (pageNumber == null || pageNumber < 0) pageNumber = DEFAULT_PAGE_NUMBER;
        if (pageSize == null || pageSize < 0) pageSize = DEFAULT_PAGE_NUMBER;

        BeerPagedList beerPagedListDto = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);


        return ResponseEntity.ok(beerPagedListDto);
    }

    @GetMapping("/beer/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(
            @PathVariable UUID beerId,
            @RequestParam(value = "showInventoryOnHand", required = false, defaultValue = "false") boolean showBeerOnHand

    ) {
        return ResponseEntity.ok(beerService.getById(beerId, showBeerOnHand));
    }

    @GetMapping("/beerUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc(
            @PathVariable String upc,
            @RequestParam(value = "showInventoryOnHand", required = false, defaultValue = "false") boolean showBeerOnHand

    ) {
        return ResponseEntity.ok(beerService.getByUpc(upc, showBeerOnHand));
    }

    @PostMapping("/beer")
    public ResponseEntity<Object> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        BeerDto newBeer = beerService.saveNewBeer(beerDto);
        return ResponseEntity.created(URI.create("/api/v1/beer/" + newBeer.getId().toString()))
                .body(BeerDto.builder().build());
    }

    @PutMapping("/beer/{beerId}")
    public ResponseEntity<Object> updateBeerById(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/beer/{beerId}")
    public ResponseEntity<Object> deleteBeerById(@PathVariable UUID beerId) {
        return ResponseEntity.noContent().build();
    }
}
