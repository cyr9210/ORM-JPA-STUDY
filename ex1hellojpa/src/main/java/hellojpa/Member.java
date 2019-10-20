package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
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

//    @ManyToOne
//    @JoinColumn(name = "team_id", insertable = false, updatable = false)
//    private Team team;

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

//    public Team getTeam() {
//        return team;
//    }

//    public void changeTeam (Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
