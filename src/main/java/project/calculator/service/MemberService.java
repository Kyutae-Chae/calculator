package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.calculator.domain.member.Member;
import project.calculator.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
    }

}
