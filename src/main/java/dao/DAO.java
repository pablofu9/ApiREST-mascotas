package dao;

import entity.Dueno;
import entity.Perro;

import java.util.List;

public interface DAO {


    List<Dueno> findAllDuenos();

    List<Perro> findAllPerros();

    Dueno findByIdDueno(int id);

    Perro findByIdPerro(int id);

    void saveDueno(Dueno dueno);

    void savePerro(Perro perro);
}
