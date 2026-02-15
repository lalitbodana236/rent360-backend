package in.rent360.propertyservice.controller;

import in.rent360.propertyservice.dto.request.PropertyCreateRequestDto;
import in.rent360.propertyservice.model.Property;
import in.rent360.propertyservice.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @GetMapping("")
    public ResponseEntity<List<Property>> getAllProperties(){

        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id){

        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/getAllPropertyByOwnerId/{ownerId}")
    public ResponseEntity<List<Property>> getAllPropertyByOwnerId(@PathVariable Long ownerId){

        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping(path ="/createProperty")
    public ResponseEntity<Property> createProperty(@RequestBody PropertyCreateRequestDto property) {
        System.out.println("insert createProperty");
        Property savedProperty = propertyService.createProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProperty);
    }


}
