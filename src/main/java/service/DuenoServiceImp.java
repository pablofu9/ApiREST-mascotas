package service;

import dao.DuenoDAO;
import entity.Dueno;
import entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class DuenoServiceImp implements DuenoService {

    @Autowired
    private DuenoDAO dao;

    @Override
    public List<Dueno> findAllDuenos(){
        List<Dueno> listaDuenos= dao.findAllDuenos();
        return listaDuenos;

    }

    @Override
    public Dueno findByIdDueno(int id){
        Dueno dueno = dao.findByIdDueno(id);
        return dueno;
    }


}
