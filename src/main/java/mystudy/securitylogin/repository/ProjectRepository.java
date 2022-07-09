package mystudy.securitylogin.repository;

import lombok.RequiredArgsConstructor;
import mystudy.securitylogin.domain.project.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ProjectRepository {

    private final EntityManager em;

    public Long save(Project project) {
        em.persist(project);
        return project.getCode();
    }

    public Project findOne(Long code) {
        return em.find(Project.class, code);
    }


}
