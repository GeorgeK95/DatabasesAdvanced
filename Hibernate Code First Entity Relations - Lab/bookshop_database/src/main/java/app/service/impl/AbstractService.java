package app.service.impl;

import app.dao.api.Dao;
import app.dao.imp.AuthorsDaoImpl;
import app.dao.imp.BooksDaoImpl;
import app.dao.imp.CategoriesDaoImpl;
import app.service.api.AuthorService;
import app.service.api.BookService;
import app.service.api.CategoryService;
import app.service.api.Service;
import app.transaction.Command;
import app.transaction.MultiCommand;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public abstract class AbstractService<E, K> implements Service<E, K> {
    protected Dao<E, K> dao;

    public AbstractService() {
        if (this instanceof BookService) {
            dao = new BooksDaoImpl();
        } else if (this instanceof AuthorService) {
            dao = new AuthorsDaoImpl();
        } else if (this instanceof CategoryService) {
            dao = new CategoriesDaoImpl();
        }
    }

    @Override
    public E runInTransaction(Command<E> command) {
        try {
            dao.beginTransaction();
            E executed = command.execute();
            dao.commit();
            return executed;
        } catch (Exception e) {
            dao.rollback();
            throw e;
        }
    }

    @Override
    public List<E> runInTransaction(MultiCommand<E> command) {
        try {
            dao.beginTransaction();
            List<E> executedCommands = command.execute();
            dao.commit();
            return executedCommands;
        } catch (Exception e) {
            dao.rollback();
            throw e;
        }
    }

    @Override
    public void save(E entity) {
        try {
            dao.beginTransaction();
            dao.save(entity);
            dao.commit();
        } catch (Exception e) {
            dao.rollback();
            throw e;
        }
    }

    @Override
    public void remove(E entity) {
        try {
            dao.beginTransaction();
            dao.remove(entity);
            dao.commit();
        } catch (Exception e) {
            dao.rollback();
            throw e;
        }
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        return runInTransaction(new MultiCommand<E>() {
            @Override
            public List<E> execute() {
                return dao.findAll(eClass);
            }
        });
    }

    @Override
    public E findById(Class<E> eClass, K primary) {
        return runInTransaction(new Command<E>() {
            @Override
            public E execute() {
                return dao.findById(eClass, primary);
            }
        });
    }
}
