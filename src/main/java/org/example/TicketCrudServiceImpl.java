package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TicketCrudServiceImpl implements TicketCrudService {
    private EntityManager entityManager;

    public TicketCrudServiceImpl(EntityManagerFactory emf) {
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public Ticket create(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Client, FromPlanet and ToPlanet cannot be null");
        }
        entityManager.persist(ticket);
        return ticket;
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Client, FromPlanet and ToPlanet cannot be null");
        }
        return entityManager.merge(ticket);
    }

    @Override
    public void delete(Integer id) {
        Ticket ticket = findById(id);
        if (ticket != null) {
            entityManager.remove(ticket);
        }
    }

    @Override
    public Ticket findById(Integer id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public List<Ticket> findAll() {
        return entityManager.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
    }
}