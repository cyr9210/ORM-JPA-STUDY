package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

  private String city;
  private String street;
  private String zip_code;

  public Address(String city, String street, String zip_code) {
    this.city = city;
    this.street = street;
    this.zip_code = zip_code;
  }

  public Address() {
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setZip_code(String zip_code) {
    this.zip_code = zip_code;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getZip_code() {
    return zip_code;
  }
}
