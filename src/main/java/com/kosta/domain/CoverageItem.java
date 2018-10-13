package com.kosta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity @Data
public class CoverageItem {

	@JsonIgnore
	@ManyToOne(targetEntity = InsuranceProduct.class)
	@JoinColumn(name = "InsuranceProductID")
	InsuranceProduct insuranceProduct;

	@OneToMany(mappedBy = "coverageItem", fetch = FetchType.EAGER)
	List<CoverageItemOption> coverageItemOptions;

	@Id
	private String ID;
	private String name;

}