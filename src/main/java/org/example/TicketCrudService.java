package org.example;

import java.util.List;

public interface TicketCrudService {
    Ticket create(Ticket ticket);
    Ticket update(Ticket ticket);
    void delete(Integer id);
    Ticket findById(Integer id);
    List<Ticket> findAll();
}