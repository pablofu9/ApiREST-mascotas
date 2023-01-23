package dao;

import entity.Dueno;
import entity.Perro;

import java.util.List;

public interface DuenoDAO {


    List<Dueno> findAllDuenos();


    Dueno findByIdDueno(int id);

    void saveDueno(Dueno dueno);


}
