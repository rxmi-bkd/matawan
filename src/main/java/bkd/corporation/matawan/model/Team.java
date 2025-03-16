package bkd.corporation.matawan.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String acronym;
  private Integer budget;

  // I used cascade = CascadeType.ALL and orphanRemoval = true to make sure that when a team is
  // deleted, all its players are deleted as well and when a player is removed from a team, it is
  // deleted from the database.
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "team_id")
  private List<Player> players = new ArrayList<>();
}
