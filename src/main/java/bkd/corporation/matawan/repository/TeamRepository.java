package bkd.corporation.matawan.repository;

import bkd.corporation.matawan.model.Team;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
  List<Team> findAll(Pageable pageable);
}
