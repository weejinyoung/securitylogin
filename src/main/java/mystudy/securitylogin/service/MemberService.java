package mystudy.securitylogin.service;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.member.Member;
import mystudy.securitylogin.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public Long UserSignUp(Member member) {
        return null;
    }

    public void validationDuplicateMember(Long code) {
        if (memberRepository.findOne(code) == null) {

        }
    }
}
