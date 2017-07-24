package app.dao;

import app.service.impl.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Repository
@Transactional
public interface BasicShampooDao extends JpaRepository<BasicShampoo, Long> {
}
