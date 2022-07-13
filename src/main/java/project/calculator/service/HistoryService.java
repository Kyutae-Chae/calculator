package project.calculator.service;

import lombok.RequiredArgsConstructor;
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

    //history service 삭제 구현필요
    public HistoryEntity deleteHistory(Long historyId) {
        Optional<HistoryEntity> optionalHistory = historyRepository.findById(historyId);
        HistoryEntity findHistory = optionalHistory.orElseThrow(()->
                new HistoryException(ExceptionCode.HISTORY_NOT_FOUND)
        );
        historyRepository.delete(findHistory);
        return findHistory;
    }

}
