package service;

import dao.DAO;
import entity.Dueno;
import entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {


    List<Dueno> findAllDuenos();

    List<Perro> findAllPerros();

    Dueno findByIdDueno(int id);

    Perro findByIdPerro(int id);
}
