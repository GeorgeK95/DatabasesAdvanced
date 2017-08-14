package app.dao;

import app.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchDao extends JpaRepository<Branch, Long> {
    Branch findByName(String name);

    @Query("select b.name, b.town.name,sum(p.clients) as totalClients from Branch b " +
            "inner join b.products p " +
            "group by b " +
            "order by totalClients desc")
    List<Object[]> topBranches();
}
