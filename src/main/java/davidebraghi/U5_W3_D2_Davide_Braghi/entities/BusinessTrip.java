package davidebraghi.U5_W3_D1_Davide_Braghi.entities;

import davidebraghi.U5_W3_D1_Davide_Braghi.enums.BusinessTripStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "businessTrips")
public class BusinessTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long businessTripId;
    private String destination;
    private LocalDate reservationDate;
    @Enumerated
    private BusinessTripStatus status;
}
