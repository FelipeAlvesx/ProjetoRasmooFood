package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.ClientDao;
import br.com.rasmoo.restaurant.dao.DishDao;
import br.com.rasmoo.restaurant.dao.OrderDao;
import br.com.rasmoo.restaurant.entity.*;
import br.com.rasmoo.restaurant.util.DataCharge;
import br.com.rasmoo.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public class OrderService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManegerRasFood();
        entityManager.getTransaction().begin();

        DataCharge.addCategories(entityManager);
        DataCharge.addProduct(entityManager);

        DishDao dishDao = new DishDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);
        OrderDao orderDao = new OrderDao(entityManager);

        Client client1 = new Client("000.000.000.01", "Daniel Fraga de Souza");
        Address address1 = new Address(client1, "42709200", "Black Clover Street",
                "in front of BK", "Los Angels", "california");
        client1.addAdress(address1);
        Order order = new Order(client1);
        order.addOrderDish(new OrdersDish(dishDao.getEntity(1), 2));

        clientDao.createClient(client1);
        orderDao.createOrder(order);
        System.out.println(order);
        entityManager.getTransaction().commit();
        entityManager.close();



    }

}
