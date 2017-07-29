package app.dao;

import app.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface AddressDao extends JpaRepository<Address, Long> {
}
