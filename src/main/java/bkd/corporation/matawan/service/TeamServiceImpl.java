package bkd.corporation.matawan.service;

import bkd.corporation.matawan.model.Team;
import bkd.corporation.matawan.repository.TeamRepository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
  private final TeamRepository teamRepository;

  public TeamServiceImpl(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public Team create(Team team) {
    return teamRepository.save(team);
  }

  @Override
  public List<Team> findAll(Pageable pageable) {
    return teamRepository.findAll(pageable);
  }
}
