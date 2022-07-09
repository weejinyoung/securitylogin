package mystudy.securitylogin.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "게스트"),
    MEMBER("ROLE_MEMBER", "멤버");

    private final String key;
    private final String title;
}