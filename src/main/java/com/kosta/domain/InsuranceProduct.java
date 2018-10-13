package com.kosta.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity @Data
public class InsuranceProduct {

	@Id
	private String ID;
	private String name;

	@OneToMany(mappedBy = "insuranceProduct", fetch = FetchType.EAGER)
    private List<CoverageItem> coverageItems;

}