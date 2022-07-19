package project.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.calculator.domain.member.Member;
import project.calculator.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(Member member) {
        //중복회원 체크
        if (this.findMember(member.getLoginId()).size() > 0)
            return null;
        return memberRepository.save(member);
    }

    public List<Member> findMember(String memberId) {
        return memberRepository.findByLoginId(memberId);
    }

}
