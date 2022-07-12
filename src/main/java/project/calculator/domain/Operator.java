package project.calculator.domain;

import lombok.Getter;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVISION("/");

    @Getter
    private String type;

    Operator(String type) {
        this.type = type;
    }
}
