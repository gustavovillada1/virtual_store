package co.edu.icesi.virtualstore.model;


import co.edu.icesi.virtualstore.constans.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class)
    private List<OrderItem> orderItems;

    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userId;

    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }



}