package com.kosta.rules;

public class Or<T> extends And<T> {
    
    public Or(Rule[] childRules) {
        super(childRules);
    }

    @Override
    public boolean meet(T t) {
        for(Rule rule : childRules){
            if(rule.meet(t)) return true;
        }

        return false;
    }
}
