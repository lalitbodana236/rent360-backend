package in.rent360.propertyservice.model;

import in.rent360.propertyservice.enums.PropertyAddedBy;
import in.rent360.propertyservice.enums.PropertyStatus;
import in.rent360.propertyservice.enums.PropertyType;
import in.rent360.propertyservice.utills.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Property extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private PropertyAddedBy propertyAddedBy;

    private Long userId;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Floor> floors;

    private PropertyType propertyType;

    private PropertyStatus propertyStatus;

}
