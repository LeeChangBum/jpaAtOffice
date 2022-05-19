package jpabook.jpashop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter -> 임베디드객체는 변하지 않는 것이 좋으므로 만들지 말자
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //이거 재정의 안하면 제대로 객체 지우는 걸 못한다.
    @Override
    public boolean equals(Object obj) {//equals 문을 꼭 필드를 모두 비교하는 걸로 override해주자!!!
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Address address= (Address) obj;
        return (Objects.equals(getCity(),address.getCity())&&Objects.equals(getStreet(),address.getStreet())&&Objects.equals(getZipcode(), address.getZipcode()));
    }

    @Override
    public  int hashCode(){
        return Objects.hash(city, street, zipcode);
    }

}
