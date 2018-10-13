package com.kosta.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "child", types = {InsuranceProduct.class})
public interface InsuranceProductWithChild {

    @Value("#{target.ID}")
    String getId();

    String getName();

    List<CoverageItemWIthChild> getCoverageItems();
}
