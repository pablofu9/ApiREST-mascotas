package service;

import dao.PerroDAO;
import entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PerroServiceImp implements PerroService{

    @Autowired
    private PerroDAO dao;

    @Override
    public List<Perro> findAllPerros(){
        List<Perro> listaPerros= dao.findAllPerros();
        return listaPerros;

    }
    @Override
    public Perro findByIdPerro(int id){
        Perro perro = dao.findByIdPerro(id);
        return perro;
    }
}
