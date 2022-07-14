package project.calculator.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.calculator.domain.member.Member;
import project.calculator.service.LogService;

import java.util.*;

//@Repository
@RequiredArgsConstructor
public class MemoryMemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private final LogService log;

    private static long sequence = 0L; //static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info(member.toString());
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
