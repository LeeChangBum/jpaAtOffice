package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /*
    @ElementCollection//member에서 list를 만들고 싶을 때 사용
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =//DB에서는 list라는 개념이 없으므로 테이블을 따로 만들어준다. 안의 속성들은 name(테이블 명), joincolumns(MEMBER_ID를 foriegn key로 하는 컬럼)
        @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME")
    private Set<String> favoriteFoods=new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
        @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory=new ArrayList<>();
    */


    @OneToMany(mappedBy="member")
    private List<Order> orders= new ArrayList<>();



}
