package com.fusionkoding.bruskibeerservice.events;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -7259726973854676554L;

    private final BeerDto beerDto;
}
