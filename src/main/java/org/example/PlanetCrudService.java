package org.example;

import java.util.List;

public interface PlanetCrudService {
    Planet create(Planet planet);
    Planet update(Planet planet);
    void delete(String id);
    Planet findById(String id);
    List<Planet> findAll();
}