package co.edu.icesi.virtualstore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "permission")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID permissionId;

    @Column(name = "uri")
    private String uri;

    @Column(name = "method")
    private String method;

    @PrePersist
    public void generateId(){
        this.permissionId = UUID.randomUUID();
    }

}