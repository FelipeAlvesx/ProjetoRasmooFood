package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createCategory(final Category category){
        this.entityManager.persist(category);
    }

    public Category getCategory(final Integer id){
        return this.entityManager.find(Category.class, id);
    }

    public List<Category> getCategoryAll(){
        String query = "SELECT c FROM Category c";
        return this.entityManager.createQuery(query, Category.class).getResultList();
    }

    public void updateCategory(final Category category){
        this.entityManager.merge(category);

    }

    public void removeCategory(final Category category){
        this.entityManager.remove(category);
    }

}
