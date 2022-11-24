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
@Table(name = "`order_item`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID orderItemId;

    private int quanty;

    @PrePersist
    public void generateId(){
        this.orderItemId = UUID.randomUUID();
    }



}