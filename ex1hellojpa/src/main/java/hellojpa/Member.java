package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products = new ArrayList<>();

//    @OneToOne
//    @JoinColumn(name = "locker_id")
//    private Locker locker;

    @ManyToOne
    @JoinColumn(name = "team_id")

    private Team team;

//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;

    public Member() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}