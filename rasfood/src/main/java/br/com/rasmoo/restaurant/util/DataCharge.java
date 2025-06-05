package br.com.rasmoo.restaurant.util;

import br.com.rasmoo.restaurant.dao.CategoryDao;
import br.com.rasmoo.restaurant.dao.DishDao;
import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Dish;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class DataCharge {

    private DataCharge(){}

    public static void addCategories(EntityManager entityManager){
        Category entrance = new Category("entrance");
        Category main = new Category("main");
        Category dessert = new Category("dessert");

        CategoryDao categoryDao = new CategoryDao(entityManager);

        categoryDao.createCategory(entrance);
        entityManager.flush();
        categoryDao.createCategory(main);
        entityManager.flush();
        categoryDao.createCategory(dessert);
        entityManager.flush();
        entityManager.clear();
    }


    public static void addProduct(EntityManager entityManager){
        CategoryDao categoryDao = new CategoryDao(entityManager);
        DishDao dishDao = new DishDao(entityManager);

        List<Category> categories = categoryDao.getCategoryAll();
        Dish pasta = new Dish("Pasta", "Pasta with Pollo pieces",
                true, BigDecimal.valueOf(55.50), categories.get(1));
        Dish frenchFries = new Dish("French Fries", "papas fritas",
                true, BigDecimal.valueOf(33.50), categories.get(0));
        Dish petitGateu = new Dish("Petit Gateu", "Petit Gateu w/ Ice Cream",
                true, BigDecimal.valueOf(40.00), categories.get(2));

        dishDao.createEntity(pasta);
        dishDao.createEntity(frenchFries);
        dishDao.createEntity(petitGateu);
        entityManager.flush();
        entityManager.clear();


    }




}
