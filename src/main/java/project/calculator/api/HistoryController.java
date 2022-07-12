package project.calculator.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.HistoryEntity;
import project.calculator.domain.ResponseDto;
import project.calculator.domain.ResponseHistoryDto;
import project.calculator.mapper.HistoryEntityMapper;
import project.calculator.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    private final HistoryEntityMapper mapper;

    @GetMapping
    public ResponseEntity getHistoryAll() {
        List<ResponseDto> historyList = new ArrayList<>();
        List<HistoryEntity> all = historyService.findHistoryAll();
        //entity를 dto로 매핑필요
        return new ResponseEntity<>(new ResponseHistoryDto<>(all), HttpStatus.OK);
    }

    @GetMapping("/{historyId}")
    public ResponseEntity historyGet(@PathVariable("historyId") Long historyId) {
        HistoryEntity history = historyService.findHistory(historyId);
        HistoryDto response = mapper.HistoryEntityToHistoryDto(history);
        //mapper 매핑 확인필요
        return new ResponseEntity<>(new ResponseHistoryDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{historyId}")
    public ResponseEntity historyDelete(@PathVariable("historyId") Long historyId) {
        HistoryEntity history = historyService.findHistory(historyId);

        //삭제 기능 구현필요
        
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
