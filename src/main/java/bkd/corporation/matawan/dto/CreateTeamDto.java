package bkd.corporation.matawan.dto;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Data;

@Data
public class CreateTeamDto {
  @Valid private TeamDto team;
  @Valid private List<PlayerDto> players;
}
