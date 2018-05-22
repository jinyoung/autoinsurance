package com.kosta.rules;

import com.kosta.domain.Customer;

public class Or extends And {
    
    public Or(Rule[] childRules) {
        super(childRules);
    }

    @Override
    public boolean meet(Customer customer) {
        for(Rule rule : childRules){
            if(rule.meet(customer)) return true;
        }

        return false;
    }
}
