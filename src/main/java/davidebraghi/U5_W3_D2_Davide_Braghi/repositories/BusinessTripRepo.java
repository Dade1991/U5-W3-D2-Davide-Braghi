package davidebraghi.U5_W3_D1_Davide_Braghi.repositories;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.BusinessTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessTripRepo extends JpaRepository<BusinessTrip, Long> {
    Optional<BusinessTrip> findByDestination(String destination);
}
