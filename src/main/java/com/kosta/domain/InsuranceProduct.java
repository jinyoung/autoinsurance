package com.kosta.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data
public class InsuranceProduct {

	@Id
	private String ID;
	private String name;

}