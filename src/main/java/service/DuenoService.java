package service;

import entity.Dueno;
import entity.Perro;

import java.util.List;


public interface DuenoService {


    List<Dueno> findAllDuenos();



    Dueno findByIdDueno(int id);


}
