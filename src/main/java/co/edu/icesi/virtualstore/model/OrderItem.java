package co.edu.icesi.virtualstore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "`order_item`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID orderItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "item_id")
    private UUID itemId;

    @PrePersist
    public void generateId(){
        this.orderItemId = UUID.randomUUID();
    }

}