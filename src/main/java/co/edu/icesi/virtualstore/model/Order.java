package co.edu.icesi.virtualstore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table(name = "`order`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID orderId;

    private double total;

    private String status;


    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }



}