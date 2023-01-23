package dao;

import entity.Dueno;
import entity.Perro;

import java.util.List;

public interface DuenoDAO {


    public List<Dueno> findAllDuenos();

    public Dueno findByIdDueno(int id);

    public void saveDueno(Dueno dueno);


}
