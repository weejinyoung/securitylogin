package mystudy.securitylogin.service;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.member.Member;
import mystudy.securitylogin.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository userRepository;

    public Long UserSignUp(Member member) {
        return null;
    }
}
