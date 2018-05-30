package com.kosta.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @Embeddable
public class InsuredDriverPK implements Serializable {

    private String customer;
    private Long insurancePolicy;

}
