package service;

import entity.Perro;

import java.util.List;

public interface PerroService {
    List<Perro> findAllPerros();

    Perro findByIdPerro(int id);
}
