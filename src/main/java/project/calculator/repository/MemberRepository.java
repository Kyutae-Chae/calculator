package project.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.calculator.domain.member.Member;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByLoginId(String loginId);
}
