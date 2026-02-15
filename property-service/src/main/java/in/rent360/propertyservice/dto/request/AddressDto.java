package in.rent360.propertyservice.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddressDto {
    private String line1;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
