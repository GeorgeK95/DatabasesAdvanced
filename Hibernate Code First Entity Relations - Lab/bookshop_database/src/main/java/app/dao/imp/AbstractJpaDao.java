package app.dao.imp;

import app.dao.api.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public abstract class AbstractJpaDao implements Dao {

    protected final EntityManager em;

    public AbstractJpaDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookshopdb");
        em = emf.createEntityManager();
    }

    @Override
    public void rollback() {
        em.getTransaction().rollback();
    }

    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @Override
    public void save(Object entity) {
        em.persist(entity);
    }

    @Override
    public void remove(Object entity) {
        em.remove(entity);
    }

    @Override
    public List findAll(Class aClass) {
        return em.createQuery("FROM " + aClass.getSimpleName()).getResultList();
    }

    @Override
    public Object findById(Class aClass, Object primary) {
        return em.find(aClass, primary);
    }
}
