package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Order;
import br.com.rasmoo.restaurant.entity.OrdersDish;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDao {

    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createOrder(final Order order){
        this.entityManager.persist(order);
    }

    public Order getOrder(final Integer id){
        return this.entityManager.find(Order.class, id);
    }

    public List<Order> getOrderAll(){
        String query = "SELECT c FROM Order c";
        return this.entityManager.createQuery(query, Order.class).getResultList();
    }

    public void updateOrder(final Order order){
        this.entityManager.merge(order);

    }

    public void removeOrder(final Order order){
        this.entityManager.remove(order);
    }

}
