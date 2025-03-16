package bkd.corporation.matawan.dto;

import bkd.corporation.matawan.model.Player;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerDto {
  @NotNull(message = "name is required")
  @NotBlank(message = "name is required")
  private String name;

  @NotNull(message = "position is required")
  @NotBlank(message = "position is required")
  private String position;

  public Player toEntity() {
    Player player = new Player();
    player.setName(this.name);
    player.setPosition(this.position);
    return player;
  }
}
