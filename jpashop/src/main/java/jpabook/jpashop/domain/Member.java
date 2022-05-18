package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;

    @Embedded//임베디드 타입-> 데이터베이스에는 그냥 클래스안의 필드들이 컬럼으로써 매핑된다.(그냥 member 테이블에 임베디드 클래스의 필드를 다 썼다고 생각하면된다.)
    private Period Workperiod;

    @Embedded
    private Address homeaddress;



    @OneToMany(mappedBy="member")
    private List<Order> orders= new ArrayList<>();
}
