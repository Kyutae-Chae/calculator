package project.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfoDto {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
