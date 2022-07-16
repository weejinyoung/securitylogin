package mystudy.securitylogin.domain.support;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mystudy.securitylogin.domain.project.Project;
import mystudy.securitylogin.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Support {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User supporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private int funding;
    private String way;

    public Project cancelSupport(Project project) {
        project.getSupports().remove(this);
        return project;
    }

    @Builder
    public Support(int funding, String way, User supporter, Project project) {
        this.project = project;
        project.getSupports().add(this);
        supporter.getSupports().add(this);
        this.supporter = supporter;
        this.funding = funding;
        this.way = way;
    }
}
