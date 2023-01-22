package dao;

import entity.Dueno;
import entity.Perro;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DAOimp implements DAO {
/*
    El entity manager tiene dos responsabilidad fundamentales:
        • Define una conexión transaccional con la base de datos que debemos abrir y mantener
            abierta mientras estamos realizado operaciones. En este sentido realiza funciones
            similares a las de una conexión JDBC.
        • Además, mantiene en memoria una caché con las entidades que gestiona y es
            responsable de sincronizarlas correctamente con la base de datos cuando se realiza un
            flush. El conjunto de entidades que gestiona un entity manager se denomina su
            contexto de persistencia.

     */
    @Autowired
    private EntityManager entityManager;

    //Metodo para encontrar todos los duenos
    @Override
    public List<Dueno> findAllDuenos(){
        Session currentSession = entityManager.unwrap(Session.class);
        /*
        Si no quisieramos utilizar hibernate y usar JPA EntityManager por tanto la anterior linea nos sobraria
        EntityManager tiene una forma de hacer consultas
            EntityManager.createQuery(String, Class)
        es parte de JPA al igual que TypedQuery.getResultList() .
        Por tanto la llamada a EntityManager.unwrap() se puede eliminar y reemplazar con entityManager
         */
        Query<Dueno> theQuery = currentSession.createQuery("SELECT u from Dueno u", Dueno.class);

        List<Dueno> duenos = theQuery.getResultList();

        return duenos;
    }

    //Metodo para encontrar todos los perros
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
    public Dueno findByIdDueno(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Dueno dueno = currentSession.get(Dueno.class, id);

        return dueno;
    }
    @Override
    public Perro findByIdPerro(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Perro perro = currentSession.get(Perro.class, id);

        return perro;
    }

    @Override
    public void saveDueno(Dueno dueno) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction t = currentSession.beginTransaction();
        currentSession.saveOrUpdate(dueno);
        t.commit();
        currentSession.close();

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
