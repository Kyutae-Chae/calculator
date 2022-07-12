package project.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.calculator.domain.HistoryEntity;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
}
