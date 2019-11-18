package jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
