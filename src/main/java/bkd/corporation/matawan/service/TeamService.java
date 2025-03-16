package bkd.corporation.matawan.service;

import bkd.corporation.matawan.model.Team;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface TeamService {
  Team create(Team team);

  List<Team> findAll(Pageable pageable);
}
