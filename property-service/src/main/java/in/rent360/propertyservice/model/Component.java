package in.rent360.propertyservice.model;

import in.rent360.propertyservice.enums.ComponentType;
import in.rent360.propertyservice.utills.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Component  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private ComponentType componentType;

    private String imageUrl;

}
