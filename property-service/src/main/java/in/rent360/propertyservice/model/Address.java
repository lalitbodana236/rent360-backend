package in.rent360.propertyservice.model;

import in.rent360.propertyservice.utills.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String line1;

    private String city;

    private String state;

    private String country;

    private String pinCode;

    private BigDecimal latitude;

    private BigDecimal longitude;
}