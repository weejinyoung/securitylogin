package mystudy.securitylogin.service;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.user.User;
import mystudy.securitylogin.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final UserRepository userRepository;

    public Long UserSignUp(User member) {
        return null;
    }
}
