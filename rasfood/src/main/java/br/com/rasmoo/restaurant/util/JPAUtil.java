package br.com.rasmoo.restaurant.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RASFOOD = Persistence.createEntityManagerFactory("rasFood");

    public static EntityManager getEntityManegerRasFood(){
        return RASFOOD.createEntityManager();
    }


}
