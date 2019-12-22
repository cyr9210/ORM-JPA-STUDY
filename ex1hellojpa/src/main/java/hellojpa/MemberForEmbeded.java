package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  @ElementCollection
  @CollectionTable(name = "favoirite_foods", joinColumns = @JoinColumn(name = "member_id"))
  @Column(name = "food_name")
  private Set<String> favoriteFoods = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "member_id"))
  private List<Address> addressHistory = new ArrayList<>();

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

  public Set<String> getFavoriteFoods() {
    return favoriteFoods;
  }

  public void setFavoriteFoods(Set<String> favoriteFoods) {
    this.favoriteFoods = favoriteFoods;
  }

  public List<Address> getAddressHistory() {
    return addressHistory;
  }

  public void setAddressHistory(List<Address> addressHistory) {
    this.addressHistory = addressHistory;
  }
}
