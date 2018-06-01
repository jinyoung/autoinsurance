package com.kosta.rules;

public interface Rule<T> {

    boolean meet(T t);
}
