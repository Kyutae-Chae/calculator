package project.calculator.domain;

import lombok.Getter;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DEVISION("/");

    @Getter
    private String type;

    Operator(String type) {
        this.type = type;
    }
}
