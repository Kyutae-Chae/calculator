package project.calculator.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.HistoryEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryEntityMapper {
    HistoryDto HistoryEntityToHistoryDto(HistoryEntity historyEntity);
    List<HistoryDto> HistoryEntityListToHistoryDtoList(Page<HistoryEntity> historyEntityList);
    List<HistoryDto> HistoryEntityListToHistoryDtoList(List<HistoryEntity> historyEntityList);
}
