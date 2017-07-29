package app.service.impl;

import app.dao.AddressDao;
import app.model.Address;
import app.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Service
public class AddressServiceImpl implements AddressService<Address, Long> {

    @Autowired
    private AddressDao dao;

    @Override
    public Address findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Address object) {
        dao.delete(object);
    }

    @Override
    public List<Address> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Address object) {
        dao.save(object);
    }
}
