package com.fusionkoding.bruskibeerservice.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedListDto extends PageImpl<BeerDto> {

    private static final long serialVersionUID = -7259726973854676554L;

    public BeerPagedListDto(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
        // TODO Auto-generated constructor stub
    }

    public BeerPagedListDto(List<BeerDto> content) {
        super(content);
        // TODO Auto-generated constructor stub
    }

}
