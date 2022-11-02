package danielvishnievskyi.bachelorproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Building {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @JoinColumn(name = "building_id")
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Device> devices;

  public Building(String name) {
    this.name = name;
  }

  public Building(String name, Collection<Device> devices) {
    this.name = name;
    this.devices = devices;
  }
}