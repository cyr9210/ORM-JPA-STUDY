package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
