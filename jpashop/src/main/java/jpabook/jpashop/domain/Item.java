package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
public abstract class Item extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private int price;

    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems=new ArrayList<>();

    @OneToMany(mappedBy = "itemId")
    private List<Category_Item> categoryItem=new ArrayList<>();
}
