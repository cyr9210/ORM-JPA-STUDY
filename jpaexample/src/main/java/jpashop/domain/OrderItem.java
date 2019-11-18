package jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private Integer orderPrice;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
