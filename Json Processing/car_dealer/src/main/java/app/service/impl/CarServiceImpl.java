package app.service.impl;

import app.dao.CarDao;
import app.entities.Car;
import app.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Service
public class CarServiceImpl implements CarService<Car, Long> {

    @Autowired
    private CarDao dao;

    @Override
    public Car findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Car object) {
        dao.delete(object);
    }

    @Override
    public List<Car> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Car object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Car> object) {
        for (Car supplier : object) {
            dao.save(supplier);
        }
    }

    @Override
    public Set<Car> toyotaCars() {
        return dao.toyotaCars();
    }
}
