package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ClientCrudServiceImpl implements ClientCrudService {
    private EntityManager entityManager;

    public ClientCrudServiceImpl(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public Client create(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Override
    public void delete(Integer id) {
        Client client = findById(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }

    @Override
    public Client findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id to load cannot be null");
        }
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}