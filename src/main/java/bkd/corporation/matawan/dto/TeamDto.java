package bkd.corporation.matawan.dto;

import bkd.corporation.matawan.model.Team;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeamDto {
  @NotNull(message = "name is required")
  @NotBlank(message = "name is required")
  private String name;

  @NotNull(message = "acronym is required")
  @NotBlank(message = "acronym is required")
  private String acronym;

  @NotNull(message = "budget is required")
  @Min(value = 0, message = "budget must be greater than 0")
  private Integer budget;

  public Team toEntity() {
    Team team = new Team();
    team.setName(this.name);
    team.setAcronym(this.acronym);
    team.setBudget(this.budget);
    return team;
  }
}
