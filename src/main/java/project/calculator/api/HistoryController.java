package project.calculator.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "계산 history 전체 조회", notes = "저장된 계산 history 전체 리턴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "결과 정상 리턴")
    })
    @GetMapping
    public ResponseEntity getHistoryAll() {
        List<HistoryEntity> historyAll = historyService.findHistoryAll();
        List<HistoryDto> historyDtos = mapper.HistoryEntityListToHistoryDtoList(historyAll);
        return new ResponseEntity<>(new ResponseHistoryDto<>(historyDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "계산 history 조회", notes = "저장된 계산 history 1건 리턴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "결과 정상 리턴"),
            @ApiResponse(code = 500, message = "해당 ID의 history를 찾을 수 없음")
    })
    @GetMapping("/{historyId}")
    public ResponseEntity historyGet(@PathVariable("historyId") Long historyId) {
        HistoryEntity history = historyService.findHistory(historyId);
        HistoryDto response = mapper.HistoryEntityToHistoryDto(history);
        return new ResponseEntity<>(new ResponseHistoryDto<>(response), HttpStatus.OK);
    }

    @ApiOperation(value = "계산 history 삭제", notes = "저장된 계산 history 1건 삭제")
    @ApiResponses({
            @ApiResponse(code = 200, message = "정상삭제후 삭제한 history 반환"),
            @ApiResponse(code = 500, message = "해당 ID의 history를 찾을 수 없음")
    })
    @DeleteMapping("/{historyId}")
    public ResponseEntity historyDelete(@PathVariable("historyId") Long historyId) {
        HistoryEntity historyEntity = historyService.deleteHistory(historyId);
        return new ResponseEntity<>(new ResponseHistoryDto<>(historyEntity), HttpStatus.OK);
    }
}
