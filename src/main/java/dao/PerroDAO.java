package dao;

import entity.Perro;

import java.util.List;

public interface PerroDAO {
    List<Perro> findAllPerros();

    Perro findByIdPerro(int id);

    void savePerro(Perro perro);
}
