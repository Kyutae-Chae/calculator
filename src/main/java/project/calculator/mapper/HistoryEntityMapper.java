package project.calculator.mapper;

import org.mapstruct.Mapper;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.HistoryEntity;

@Mapper(componentModel = "spring")
public interface HistoryEntityMapper {
    HistoryDto HistoryEntityToHistoryDto(HistoryEntity historyEntity);
}
