package in.rent360.propertyservice.repository;

import in.rent360.propertyservice.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropertyRepository extends JpaRepository<Property , Long> {
}
