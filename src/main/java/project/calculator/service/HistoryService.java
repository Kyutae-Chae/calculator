package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.calculator.domain.HistoryEntity;
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
                //new RuntimeException("history not found.")
                new HistoryException("해당 계산 history를 찾을 수 없습니다.")
        );
        return findHistory;
    }

    public List<HistoryEntity> findHistoryAll() {
        return historyRepository.findAll();
    }

}
