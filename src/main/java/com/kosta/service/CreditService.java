package com.kosta.service;

import com.kosta.domain.Policyholder;

public interface CreditService {

    CreditRate getCredit(Policyholder p);

}
