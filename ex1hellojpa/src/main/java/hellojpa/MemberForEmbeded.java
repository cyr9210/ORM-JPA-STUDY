package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class MemberForEmbeded {

  @Id @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String username;

  private LocalDateTime startDate;
  private LocalDateTime endDate;

  private String city;
  private String street;
  private String zip_code;

}
