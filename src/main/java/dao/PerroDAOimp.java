package dao;

import entity.Perro;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerroDAOimp implements PerroDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Perro> findAllPerros(){
        Session currentSession = entityManager.unwrap(Session.class);
        /*
        Si no quisieramos utilizar hibernate y usar JPA EntityManager por tanto la anterior linea nos sobraria
        EntityManager tiene una forma de hacer consultas
            EntityManager.createQuery(String, Class)
        es parte de JPA al igual que TypedQuery.getResultList() .
        Por tanto la llamada a EntityManager.unwrap() se puede eliminar y reemplazar con entityManager
         */
        Query<Perro> theQuery = currentSession.createQuery("SELECT u from Perro u", Perro.class);

        List<Perro> perros = theQuery.getResultList();

        return perros;
    }

    @Override
    public Perro findByIdPerro(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Perro perro = currentSession.get(Perro.class, id);

        return perro;
    }

    @Override
    public void savePerro(Perro perro) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction t = currentSession.beginTransaction();
        currentSession.saveOrUpdate(perro);
        t.commit();
        currentSession.close();

    }
}
