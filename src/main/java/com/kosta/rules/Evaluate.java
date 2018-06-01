package com.kosta.rules;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Evaluate<T, V> implements Rule<T> {

    public Evaluate(Operator operator, V compareeValue){
        setOperator(operator);
        setCompareeValue(compareeValue);
    }

    public V getCompareeValue() {
        return compareeValue;
    }

    public void setCompareeValue(V compareeValue) {
        this.compareeValue = compareeValue;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    protected V compareeValue;

    protected Operator operator;

    public static void main(String[] args) {

        ObjectMapper typedJSONSerializer = createTypedJsonObjectMapper();

//        Rule eligibility = new And(new Rule[]{
//                new Or(new Rule[]{
//                        new CreditEvaluate(">", ),
//                        new MeritalStatusEvaluate("")
//                }), new AgeEvaluate(">", new Integer(23))
//
//        });
//
//        typedJSONSerializer.writeValueAsString(eligibility);


    }


    public static ObjectMapper createTypedJsonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig()
                .getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // ignore null
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT); // ignore zero and false when it is int or boolean
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, "_type");
        return objectMapper;
    }
}
