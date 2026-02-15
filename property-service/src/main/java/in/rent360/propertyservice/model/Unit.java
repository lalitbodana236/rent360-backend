package in.rent360.propertyservice.model;

import in.rent360.propertyservice.enums.OccupancyStatus;
import in.rent360.propertyservice.enums.PropertyUnitType;
import in.rent360.propertyservice.utills.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
public class Unit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    private String unitNumber;

    private PropertyUnitType unitType;

    private BigDecimal carpetArea;

    private OccupancyStatus occupancyStatus;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Component> components;

}
