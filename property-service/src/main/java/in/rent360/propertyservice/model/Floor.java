package in.rent360.propertyservice.model;

import in.rent360.propertyservice.utills.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Floor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    private Integer floorNumber;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Unit> units;

}
