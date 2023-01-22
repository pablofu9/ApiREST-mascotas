package service;

import dao.DAO;
import entity.Dueno;
import entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImp implements Service{

    @Autowired
    private DAO dao;

    @Override
    public List<Dueno> findAllDuenos(){
        List<Dueno> listaDuenos= dao.findAllDuenos();
        return listaDuenos;



    }
    @Override
    public List<Perro> findAllPerros(){
        List<Perro> listaPerros= dao.findAllPerros();
        return listaPerros;

    }

    @Override
    public Dueno findByIdDueno(int id){
        Dueno dueno = dao.findByIdDueno(id);
        return dueno;
    }

    @Override
    public Perro findByIdPerro(int id){
        Perro perro = dao.findByIdPerro(id);
        return perro;
    }
}
