package hellojpa;

import hellojpa.inheritance.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.concurrent.locks.Lock;

@Getter
@Setter
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String name;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")//연관관계의 주인
    private Locker locker;

    @ManyToOne(fetch = FetchType.LAZY )//지연 로딩-> member find하면 team은 안가져오고 나중에 team 호출시 select쿼리 나가며 그떄 가지고옴
    @JoinColumn(name="TEMA_ID")
    private Team team;

}
