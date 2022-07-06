package mystudy.securitylogin.domain.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mystudy.securitylogin.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_code")
    private Member projectMaker;

    private String title;
    private String desc;

    private LocalDateTime openDate;
    private LocalDateTime closedDate;

    private Status status;
    private int progress;
    private int goal;

    private Status isProjectSuccess() {
        if (progress >= goal) {
            return Status.SUCCESS;
        } else {
            return Status.FAIL;
        }
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
    public Project(String title, String desc, int goal, LocalDateTime closedDate) {
        this.title = title;
        this.desc = desc;
        this.goal = goal;
        this.closedDate = closedDate;
        this.status = Status.PREPARING;
    }
}
