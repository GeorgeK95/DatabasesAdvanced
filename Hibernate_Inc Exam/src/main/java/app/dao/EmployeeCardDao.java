package app.dao;

import app.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCardDao extends JpaRepository<EmployeeCard, Long> {
    EmployeeCard findByNumber(String number);

    List<EmployeeCard> findByEmployeeNullOrderByIdAsc();
}
