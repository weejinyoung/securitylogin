package mystudy.securitylogin.domain.support;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mystudy.securitylogin.domain.member.Member;
import mystudy.securitylogin.domain.project.Project;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_code")
    private Member supporter;

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
