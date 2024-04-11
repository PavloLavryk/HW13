package org.example;

import java.util.List;

public interface ClientCrudService {
    Client create(Client client);
    Client update(Client client);
    void delete(Integer id);
    Client findById(Integer id);
    List<Client> findAll();
}