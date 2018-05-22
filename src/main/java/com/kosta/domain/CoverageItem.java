package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data
public class CoverageItem {

	@ManyToOne(targetEntity = InsuranceProduct.class)
	@JoinColumn(name = "InsuranceProductID")
	InsuranceProduct insuranceProduct;

	@OneToMany(mappedBy = "coverageItem")
	Collection<CoverageItemOption> coverageItemOptions;

	@Id
	private String ID;
	private String name;

}