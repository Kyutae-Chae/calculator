package project.calculator.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
