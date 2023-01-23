package service;

import entity.Dueno;
import entity.Perro;

import java.util.List;

@org.springframework.stereotype.Service
public interface DuenoService {


    List<Dueno> findAllDuenos();



    Dueno findByIdDueno(int id);

   
}
