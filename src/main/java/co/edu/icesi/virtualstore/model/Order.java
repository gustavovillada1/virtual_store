package co.edu.icesi.virtualstore.model;


import co.edu.icesi.virtualstore.utils.constans.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "orders")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID orderId;

    @Column(name = "total")
    private double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userId;

    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }



}