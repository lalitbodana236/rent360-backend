package in.rent360.propertyservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class FloorDto {
    private Integer floorNumber;
    private List<UnitDto> units;
}
