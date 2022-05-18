package hellojpa.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("M")//Dtype 이렇게 저장됨
@Entity
public class Movie extends Item{
    private String director;
    private String actor;

}
