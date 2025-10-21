package davidebraghi.U5_W3_D1_Davide_Braghi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate reservationDate;
    private String notes;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private BusinessTrip businessTrip;
}
