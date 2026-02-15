package in.rent360.propertyservice.dto.request;

import in.rent360.propertyservice.enums.PropertyAddedBy;
import in.rent360.propertyservice.enums.PropertyStatus;
import in.rent360.propertyservice.enums.PropertyType;
import lombok.Data;

import java.util.List;

@Data
public class PropertyCreateRequestDto {

    private String name;
    private String propertyType;
    private String propertyStatus;
    private String propertyAddedBy;
    private Long userId;

    private AddressDto address;
    private List<FloorDto> floors;

}
