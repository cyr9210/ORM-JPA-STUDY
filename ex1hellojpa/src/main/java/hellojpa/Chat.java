package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat {

    @Id
    @GeneratedValue
    private Long id;
}
