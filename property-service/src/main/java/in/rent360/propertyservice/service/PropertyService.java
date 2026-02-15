package in.rent360.propertyservice.service;

import in.rent360.propertyservice.dto.request.*;
import in.rent360.propertyservice.enums.*;
import in.rent360.propertyservice.model.Property;
import in.rent360.propertyservice.repository.IPropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import in.rent360.propertyservice.model.*;

@Service
public class PropertyService {

    private final IPropertyRepository ipropertyRepository;

    PropertyService(IPropertyRepository ipropertyRepository){
        this.ipropertyRepository = ipropertyRepository;
    }

    public List<Property> getAllProperties() {

      return ipropertyRepository.findAll();

    }

    public Property getPropertyById(Long id) {
        Optional<Property> property = ipropertyRepository.findById(id);
        return property.orElse(null);
    }

    public Property createProperty(PropertyCreateRequestDto request) {

        Property property = new Property();

        // ---------- Property ----------
        property.setName(request.getName());
        property.setPropertyType( PropertyType.valueOf( request.getPropertyType()));
        property.setPropertyStatus(PropertyStatus.valueOf( request.getPropertyStatus()));
        property.setPropertyAddedBy(PropertyAddedBy.valueOf( request.getPropertyAddedBy()));
        property.setUserId(request.getUserId());

        // ---------- Address (1-1) ----------


        Address address = mapAddress(request.getAddress());
        property.setAddress(address);

        // ---------- Floors -> Units -> Components ----------
        List<Floor> floors = mapFloors(request.getFloors(), property);
        property.setFloors(floors);

       return ipropertyRepository.save(property);
    }



    // ================== PRIVATE MAPPERS ==================

    private Address mapAddress(AddressDto dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setLine1(dto.getLine1());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPinCode(dto.getPinCode());
        address.setLatitude(dto.getLatitude());
        address.setLongitude(dto.getLongitude());

        return address;
    }

    private List<Floor> mapFloors(List<FloorDto> floorDtos, Property property) {
        if (floorDtos == null) return List.of();

        return floorDtos.stream().map(floorDto -> {

            Floor floor = new Floor();
            floor.setFloorNumber(floorDto.getFloorNumber());

            List<Unit> units = mapUnits(floorDto.getUnits(), floor);
            floor.setUnits(units);

            return floor;

        }).toList();
    }

    private List<Unit> mapUnits(List<UnitDto> unitDtos, Floor floor) {
        if (unitDtos == null) return List.of();

        return unitDtos.stream().map(unitDto -> {

            Unit unit = new Unit();
            unit.setUnitNumber(unitDto.getUnitNumber());
            unit.setUnitType(PropertyUnitType.valueOf(unitDto.getUnitType()));
            unit.setOccupancyStatus(OccupancyStatus.valueOf(unitDto.getOccupancyStatus()));
            unit.setCarpetArea(unitDto.getCarpetArea());
            unit.setFloor(floor); // 🔗 owning side

            List<Component> components = mapComponents(unitDto.getComponents(), unit);
            unit.setComponents(components);

            return unit;

        }).toList();
    }

    private List<Component> mapComponents( List<ComponentDto> componentDtos, Unit unit) {

        if (componentDtos == null) return List.of();

        return componentDtos.stream().map(dto -> {

            Component component = new Component();
            component.setComponentType(ComponentType.valueOf( dto.getComponentType()));
           // component.setUnit(dto.getUnit());
            component.setImageUrl(dto.getImageUrl());
            component.setUnit(unit); // 🔗 owning side

            return component;

        }).toList();
    }
}
