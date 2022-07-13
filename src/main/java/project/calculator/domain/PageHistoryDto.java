package project.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class PageHistoryDto {
    List<HistoryDto> data;
    PageInfoDto pageInfoDto;
}
