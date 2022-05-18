package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long Id;

    @Column(name = "TEAMNAME")
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)//cascade=CascadeType.All=이제 member 선언하고 team에 add 해주고 persist하면 모두 persist된다.
    //orphanRemoval =true-> List에서 객체를 지우면 실제 데이터베이스에서 해당 entity에 해당하는 row가 사라짐
    private List<Member> members=new ArrayList<>();
}
