package mystudy.securitylogin.domain.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mystudy.securitylogin.domain.support.Support;
import mystudy.securitylogin.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_code")
    private User projectMaker;

    @OneToMany(mappedBy = "project")
    private List<Support> supports = new ArrayList<>();

    private String title;
    private String desc;

    private LocalDateTime openDate;
    private LocalDateTime closedDate;

    private Status status;
    private int fundingProgress;
    private int fundingGoal;

    private Status isProjectSuccess() {
        if (fundingProgress >= fundingGoal) {
            return Status.SUCCESS;
        } else {
            return Status.FAIL;
        }
    }

    public void funding(int funding) {
        fundingProgress += funding;
    }

    public void projectOpen() {
        this.status = Status.OPEN;
        this.openDate = LocalDateTime.now();
    }

    public Status projectClose() {
        this.status = isProjectSuccess();
        return status;
    }

    @Builder
    public Project(String title, String desc, int fundingGoal, LocalDateTime closedDate) {
        this.title = title;
        this.desc = desc;
        this.fundingGoal = fundingGoal;
        this.closedDate = closedDate;
        this.status = Status.PREPARING;
    }
}
