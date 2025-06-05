package br.com.rasmoo.restaurant.service.test;
import br.com.rasmoo.restaurant.dao.DishDao;
import br.com.rasmoo.restaurant.util.DataCharge;
import br.com.rasmoo.restaurant.util.JPAUtil;
import javax.persistence.EntityManager;

public class DishService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManegerRasFood();
        entityManager.getTransaction().begin();
        DataCharge.addCategories(entityManager);
        DataCharge.addProduct(entityManager);
        DishDao dishDao = new DishDao(entityManager);
        System.out.println("Result:" + dishDao.getByName("PASTA"));

        entityManager.close();

    }



}
