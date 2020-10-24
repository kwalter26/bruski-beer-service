package com.fusionkoding.bruskibeerservice.web.repositories;

import java.util.UUID;

import com.fusionkoding.bruskibeerservice.domain.Beer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
