package com.fusionkoding.bruskibeerservice.services;

import com.fusionkoding.bruskibeerservice.domain.Beer;
import com.fusionkoding.bruskibeerservice.repositories.BeerRepository;
import com.fusionkoding.bruskibeerservice.web.mappers.BeerMapper;
import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDto> getAllBeers() {
        List<BeerDto> beers = new ArrayList<>();
        beerRepository.findAll().iterator().forEachRemaining(beer -> beers.add(beerMapper.beerToBeerDto(beer)));
        return beers;
    }

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        Beer newBeer = beerMapper.beerDtoToBeer(beerDto);
        Beer savedBeer = beerRepository.save(newBeer);
        return beerMapper.beerToBeerDto(savedBeer);
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

}
