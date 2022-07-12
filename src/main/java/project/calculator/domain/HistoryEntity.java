package project.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class HistoryEntity {

    @Id @GeneratedValue
    @Column(name = "history_id")
    private Long id;

    private BigDecimal result;
    @Enumerated(value = EnumType.STRING)
    private Operator operator;
    private BigDecimal operand1;
    private BigDecimal operand2;
}
