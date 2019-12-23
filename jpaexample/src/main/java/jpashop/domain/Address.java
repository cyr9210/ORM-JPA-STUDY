package jpashop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
@Getter
public class Address {

  @Column(length = 10)
  private String city;

  @Column(length = 20)
  private String street;

  @Column(length = 5)
  private String zipCode;

  public String fullAddress() {
    return getCity() + " " + getStreet() + " " + getZipCode();
  }

}
