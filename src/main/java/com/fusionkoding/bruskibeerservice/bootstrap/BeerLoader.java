package com.fusionkoding.bruskibeerservice.bootstrap;

import java.math.BigDecimal;

import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.repositories.BeerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    public static final String BEER_STYLE_1 = "Stout";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Guiness").beerStyle(BEER_STYLE_1).quantityToBrew(200)
                    .minOnHand(12).upc(BEER_1_UPC).price(new BigDecimal("12.95")).build());
            beerRepository.save(Beer.builder().beerName("Dragon's Milk").beerStyle(BEER_STYLE_1).quantityToBrew(200)
                    .minOnHand(12).upc(BEER_2_UPC).price(new BigDecimal("12.95")).build());
            beerRepository.save(Beer.builder().beerName("Gooma").beerStyle(BEER_STYLE_1).quantityToBrew(200)
                    .minOnHand(12).upc(BEER_3_UPC).price(new BigDecimal("11.95")).build());
        }
    }

}
