package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory EMF= Persistence.createEntityManagerFactory("hello");
        EntityManager EM=EMF.createEntityManager();
        EntityTransaction tx=EM.getTransaction();

        tx.begin();



        List<Member> result=EM.createQuery("select m from Member m where m.name like '%kim&'", Member.class).getResultList();


        tx.commit();

        EM.close();
        EMF.close();

    }

}
