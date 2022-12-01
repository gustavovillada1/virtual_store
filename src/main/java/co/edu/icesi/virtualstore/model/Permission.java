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

/*@Data
@Table(name = "`permission`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor*/
public class Permission {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID permissionId;

    private String uri;

    private String key;

    @PrePersist
    public void generateId(){
        this.permissionId = UUID.randomUUID();
    }

}