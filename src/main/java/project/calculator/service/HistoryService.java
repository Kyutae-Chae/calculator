package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.calculator.domain.HistoryEntity;
import project.calculator.exception.ExceptionCode;
import project.calculator.exception.HistoryException;
import project.calculator.repository.HistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final LogService logService;

    public HistoryEntity findHistory(Long historyId) {
        Optional<HistoryEntity> optionalHistory = historyRepository.findById(historyId);
        HistoryEntity findHistory = optionalHistory.orElseThrow(()->
                new HistoryException(ExceptionCode.HISTORY_NOT_FOUND)
        );
        return findHistory;
    }

    public List<HistoryEntity> findHistoryAll() {
        return historyRepository.findAll();
    }
    public Page<HistoryEntity> findHistoryPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        return historyRepository.findAll(pageRequest);
    }

    //history service 삭제 구현필요
    public HistoryEntity deleteHistory(Long historyId) {
        Optional<HistoryEntity> optionalHistory = historyRepository.findById(historyId);
        HistoryEntity findHistory = optionalHistory.orElseThrow(()->
                new HistoryException(ExceptionCode.HISTORY_NOT_FOUND)
        );
        historyRepository.delete(findHistory);
        logService.warn("delete history ID : " + historyId);
        return findHistory;
    }

}
