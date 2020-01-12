package jpql;

import javax.persistence.*;

@Entity
public class Member {

  @Id @GeneratedValue
  private Long id;

  private String name;

  private Integer age;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
