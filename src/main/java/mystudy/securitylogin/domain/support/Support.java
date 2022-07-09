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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User supporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_code")
    private Project project;

    private int funding;
    private String way;
    private String comment;

    @Builder
    public Support(String way, String comment) {
        this.way = way;
        this.comment = comment;
    }

}
