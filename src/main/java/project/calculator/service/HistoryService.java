package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.calculator.domain.HistoryDto;
import project.calculator.domain.HistoryEntity;
import project.calculator.mapper.HistoryEntityMapper;
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
                new RuntimeException("history not found.")
        );
        return findHistory;
    }

    public List<HistoryEntity> findHistoryAll() {
        return historyRepository.findAll();
    }

}
