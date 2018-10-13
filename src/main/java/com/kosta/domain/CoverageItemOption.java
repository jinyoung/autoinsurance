package com.kosta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity @Data
public class CoverageItemOption {

	@JsonIgnore
	@ManyToOne(targetEntity = CoverageItem.class)
	@JoinColumn(name = "CoverageItemID")
	CoverageItem coverageItem;

	@Id
	private String ID;
	private BigDecimal value;

}