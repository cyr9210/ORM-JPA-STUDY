package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Member> members = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
