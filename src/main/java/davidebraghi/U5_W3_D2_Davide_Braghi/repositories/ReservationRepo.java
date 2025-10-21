package davidebraghi.U5_W3_D1_Davide_Braghi.repositories;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    boolean existsByEmployee_IdAndReservationDate(Long employeeId, LocalDate reservationDate);
}