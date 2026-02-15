package in.rent360.propertyservice.dto.request;

import in.rent360.propertyservice.enums.PropertyUnitType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UnitDto {
    private String unitNumber;
    private String unitType;
    private String occupancyStatus;
    private BigDecimal carpetArea;

    private List<ComponentDto> components;
}
