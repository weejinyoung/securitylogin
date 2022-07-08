package mystudy.securitylogin.repository;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.support.Support;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class SupportRepository {

    private final EntityManager em;

    public Long save(Support support) {
        em.persist(support);
        return support.getCode();
    }

    public Support findOne(Long code) {
        return em.find(Support.class, code);
    }
}
