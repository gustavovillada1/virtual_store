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
@Table(name = "`item`")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID itemId;

    private String name;

    private String description;

    private String urlImage;

    private double price;


    @PrePersist
    public void generateId(){
        this.itemId = UUID.randomUUID();
    }



}