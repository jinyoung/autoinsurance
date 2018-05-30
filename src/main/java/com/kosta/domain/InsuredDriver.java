package com.kosta.domain;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class InsuredDriver {

	@EmbeddedId
	private InsuredDriverPK id;

	private String relationToPolicyholder;

	public void setRelation() {
		// TODO - implement InsuredDriver.setRelation
		throw new UnsupportedOperationException();
	}

}