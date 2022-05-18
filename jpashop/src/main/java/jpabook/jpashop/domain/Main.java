package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory EMF= Persistence.createEntityManagerFactory("hello");
        EntityManager EM=EMF.createEntityManager();
        EntityTransaction tx=EM.getTransaction();

        tx.begin();

        OrderItem orderItem=new OrderItem();
        orderItem.setOrderPrice(12);
        orderItem.setCount(3);

        OrderItem orderItem1=new OrderItem();
        orderItem1.setOrderPrice(15);
        orderItem1.setCount(6);

        OrderItem orderItem2=new OrderItem();
        orderItem2.setOrderPrice(4);
        orderItem2.setCount(10);


        Order order=new Order();
        order.addOrderItem(orderItem);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        EM.persist(order);

        EM.flush();
        EM.clear();

        Order order1=EM.find(Order.class, order.getId());
        System.out.println("-----------------------------------");
        List<OrderItem> orderItemList=order1.getOrderItems();
        System.out.println("-----------------------------------");

        System.out.println(orderItemList.get(0).getCount());




        tx.commit();

        EM.close();
        EMF.close();

    }

}
