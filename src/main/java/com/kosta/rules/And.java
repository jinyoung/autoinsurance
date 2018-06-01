package com.kosta.rules;

import java.util.ArrayList;
import java.util.List;

public class And<T> implements Rule<T> {
    public And(Rule[] childRules) {

        this.childRules = new ArrayList<Rule>();

        for(Rule rule : childRules)
            this.childRules.add(rule);
    }

    public And(List<Rule> childRules) {
        this.childRules = childRules;
    }

    public List<Rule> getChildRules() {
        return childRules;
    }

    public void setChildRules(List<Rule> childRules) {
        this.childRules = childRules;
    }

    List<Rule> childRules;

    @Override
    public boolean meet(T t) {
        for(Rule rule : childRules){
            if(rule.meet(t)) return false;
        }

        return true;
    }
}
