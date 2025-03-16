package bkd.corporation.matawan.controller;

import bkd.corporation.matawan.dto.CreateTeamDto;
import bkd.corporation.matawan.dto.PlayerDto;
import bkd.corporation.matawan.model.Player;
import bkd.corporation.matawan.model.Team;
import bkd.corporation.matawan.service.TeamServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {
  private final TeamServiceImpl teamService;

  public TeamController(TeamServiceImpl teamService) {
    this.teamService = teamService;
  }

  @GetMapping("/teams")
  public ResponseEntity<List<Team>> getTeams(
      @RequestParam(defaultValue = "0") String page,
      @RequestParam(defaultValue = "10") String size,
      @RequestParam(defaultValue = "asc") String direction,
      @RequestParam(defaultValue = "id") String sortBy) {

    // check if direction is valid
    Sort.Direction sortDirection =
        direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

    // check if sortBy is a valid field
    if (!sortBy.equals("name") && !sortBy.equals("acronym") && !sortBy.equals("budget")) {
      sortBy = "id";
    }

    // check if page and size are valid numbers
    int int_size;
    int int_page;

    try {
      int_page = Integer.parseInt(page);
      int_size = Integer.parseInt(size);
    } catch (NumberFormatException e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    if (int_page < 0 || int_size < 0) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    Sort sort = Sort.by(sortDirection, sortBy);
    Pageable pageable = PageRequest.of(int_page, int_size, sort);
    return new ResponseEntity<>(teamService.findAll(pageable), HttpStatus.OK);
  }

  @PostMapping("/teams")
  public ResponseEntity<String> createTeam(@Valid @RequestBody CreateTeamDto body) {
    Team team = body.getTeam().toEntity();

    // check if players are provided
    if (body.getPlayers() != null) {
      List<Player> players = body.getPlayers().stream().map(PlayerDto::toEntity).toList();
      team.setPlayers(players);
    }

    teamService.create(team);

    return new ResponseEntity<>(null, HttpStatus.CREATED);
  }
}
