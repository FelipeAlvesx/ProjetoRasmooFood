package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Dish;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


public class DishDao {

    private EntityManager entityManager;

    public DishDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createEntity(final Dish dish){
        this.entityManager.persist(dish);
        System.out.println("Entidade Criada " + dish);
    }

    public Dish getEntity(final Integer id){
        return this.entityManager.find(Dish.class, id);
    }

    public Dish getByName(final String filter){
        try {
            String query = "SELECT c FROM Dish c WHERE UPPER(c.name) = UPPER(:name)";
            return this.entityManager.createQuery(query, Dish.class).setParameter("name", filter).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public List<Dish> getByPrice(final BigDecimal price){
        try{
            String query = "SELECT c FROM Dish c WHERE c.valor = :valor";
            return this.entityManager.createQuery(query, Dish.class).setParameter("valor", price).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }

    }

    public List<Dish> getEntityAll(){
        try {
            String query = "SELECT c from Dish c";
            return this.entityManager.createQuery(query, Dish.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }

    }

    public void updateEntity(final Dish dish){
        this.entityManager.merge(dish);
    }

    public void removeEntity(final Dish dish){
        this.entityManager.remove(dish);
    }

}
