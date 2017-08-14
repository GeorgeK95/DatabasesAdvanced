package app.dao;

import app.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownDao extends JpaRepository<Town, Long> {
    Town findByName(String name);

    @Query("select t.name, t.population, sum(p.clients) as totalClients from Town t " +
            "inner join t.branches b " +
            "inner join b.products p " +
            "group by t " +
            "order by totalClients desc")
    List<Object[]> townClients();
}
