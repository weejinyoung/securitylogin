package mystudy.securitylogin.repository;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getCode();
    }

    public Member findOne(Long code) {
        return em.find(Member.class, code);
    }

}
