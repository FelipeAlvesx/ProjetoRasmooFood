package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Client;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {

    private EntityManager entityManager;

    public ClientDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createClient(final Client client){
        this.entityManager.persist(client);
    }

    public Client getClient(final Integer id){
        return this.entityManager.find(Client.class, id);
    }

    public List<Client> getClientAll(){
        String query = "SELECT c FROM Client c";
        return this.entityManager.createQuery(query, Client.class).getResultList();
    }

    public void updateClient(final Client client){
        this.entityManager.merge(client);

    }

    public void removeClient(final Client client){
        this.entityManager.remove(client);
    }

}
