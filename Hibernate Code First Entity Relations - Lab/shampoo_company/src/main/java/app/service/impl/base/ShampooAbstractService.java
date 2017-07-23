package app.service.impl.base;

import app.dao.api.ShampooDao;
import app.dao.imp.FiftyShadesDaoImpl;
import app.dao.imp.FreshNukeDaoImpl;
import app.dao.imp.PinkPantherDaoImpl;
import app.service.api.FiftyShadesService;
import app.service.api.FreshNukeService;
import app.service.api.PinkPantherService;
import app.service.api.ShampooService;
import app.transaction.Command;
import app.transaction.MultiCommand;

import java.util.List;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
public abstract class ShampooAbstractService<E, K> implements ShampooService<E, K> {
    protected ShampooDao<E, K> shampooDao;

    public ShampooAbstractService() {
        if (this instanceof FiftyShadesService) {
            shampooDao = new FiftyShadesDaoImpl();
        } else if (this instanceof FreshNukeService) {
            shampooDao = new FreshNukeDaoImpl();
        }  else if (this instanceof PinkPantherService) {
            shampooDao = new PinkPantherDaoImpl();
        }
//        else if (this instanceof LavenderDao) {
//            shampooDao = new LavenderDaoImpl();
//        } else if (this instanceof MintDao) {
//            shampooDao = new MintDaoImpl();
//        } else if (this instanceof NettleDao) {
//            shampooDao = new NettleDaoImpl();
//        }

    }

    @Override
    public E runInTransaction(Command<E> command) {
        try {
            shampooDao.beginTransaction();
            E executed = command.execute();
            shampooDao.commit();
            return executed;
        } catch (Exception e) {
            shampooDao.rollback();
            throw e;
        }
    }

    @Override
    public List<E> runInTransaction(MultiCommand<E> command) {
        try {
            shampooDao.beginTransaction();
            List<E> executedCommands = command.execute();
            shampooDao.commit();
            return executedCommands;
        } catch (Exception e) {
            shampooDao.rollback();
            throw e;
        }
    }

    @Override
    public void save(E entity) {
        try {
            shampooDao.beginTransaction();
            shampooDao.save(entity);
            shampooDao.commit();
        } catch (Exception e) {
            shampooDao.rollback();
            throw e;
        }
    }

    @Override
    public void remove(E entity) {
        try {
            shampooDao.beginTransaction();
            shampooDao.remove(entity);
            shampooDao.commit();
        } catch (Exception e) {
            shampooDao.rollback();
            throw e;
        }
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        return runInTransaction(new MultiCommand<E>() {
            @Override
            public List<E> execute() {
                return shampooDao.findAll(eClass);
            }
        });
    }

    @Override
    public E findById(Class<E> eClass, K primary) {
        return runInTransaction(new Command<E>() {
            @Override
            public E execute() {
                return shampooDao.findById(eClass, primary);
            }
        });
    }
}
