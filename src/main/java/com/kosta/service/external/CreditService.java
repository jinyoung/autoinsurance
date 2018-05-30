package com.kosta.service.external;

import com.kosta.domain.Customer;
import com.kosta.service.CreditRate;

public interface CreditService {

    CreditRate getCredit(Customer p);

}
