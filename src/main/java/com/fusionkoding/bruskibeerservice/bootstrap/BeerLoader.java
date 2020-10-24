package com.fusionkoding.bruskibeerservice.bootstrap;

import java.math.BigDecimal;

import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.repositories.BeerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

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
            beerRepository.save(Beer.builder().beerName("Guiness").beerStyle("Stout").quantityToBrew(200).minOnHand(12)
                    .upc(6574816486165L).price(new BigDecimal("12.95")).build());
            beerRepository.save(Beer.builder().beerName("Dragon's Milk").beerStyle("Stout").quantityToBrew(200)
                    .minOnHand(12).upc(6574816486164L).price(new BigDecimal("12.95")).build());
        }
    }

}
