package com.kosta.rules;

import com.kosta.domain.Customer;

public interface Rule {

    boolean meet(Customer customer);
}
