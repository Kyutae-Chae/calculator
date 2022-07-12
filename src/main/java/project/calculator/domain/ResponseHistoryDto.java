package project.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseHistoryDto<T> {
    private T data;
}
