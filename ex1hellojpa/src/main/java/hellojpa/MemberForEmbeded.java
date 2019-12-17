package hellojpa;

import javax.persistence.*;

@Entity
public class MemberForEmbeded {

  @Id @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String username;

  @Embedded
  private Period period;

  @Embedded
  private Address homeAddress;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(
          name = "city", column = @Column(name = "work_city")
      ),
      @AttributeOverride(
          name = "street", column = @Column(name = "work_street")
      ),
      @AttributeOverride(
          name = "zip_code", column = @Column(name = "work_zip_code")
      )
  })
  private Address workAddress;

  public MemberForEmbeded() {
  }

  public MemberForEmbeded(String username, Period period, Address homeAddress) {
    this.username = username;
    this.period = period;
    this.homeAddress = homeAddress;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Period getPeriod() {
    return period;
  }

  public void setPeriod(Period period) {
    this.period = period;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }
}
