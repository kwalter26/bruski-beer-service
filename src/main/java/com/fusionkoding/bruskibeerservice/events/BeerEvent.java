package com.fusionkoding.bruskibeerservice.events;

import com.fusionkoding.bruskibeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -7259726973854676554L;

    private BeerDto beerDto;
}
