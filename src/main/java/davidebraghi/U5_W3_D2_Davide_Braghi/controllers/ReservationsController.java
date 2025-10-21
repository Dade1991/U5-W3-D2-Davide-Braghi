package davidebraghi.U5_W3_D1_Davide_Braghi.controllers;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Reservation;
import davidebraghi.U5_W3_D1_Davide_Braghi.exceptions.BadRequestException;
import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.Reservations.NewReservationDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.Reservations.NewReservationResponseDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired
    ReservationsService reservationsService;

    // GET http://localhost:3001/reservations

    @GetMapping("")
    public Page<Reservation> getReservations(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return reservationsService.getReservation(page, size, sortBy);
    }

    // POST http://localhost:3001/reservations (+ body)

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public NewReservationResponseDTO saveReservation(@RequestBody @Validated NewReservationDTO body,
                                                     BindingResult validation)
            throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Reservation newReservation = reservationsService.save(body);
        return new NewReservationResponseDTO(newReservation.getId());
    }

    // GET http://localhost:3001/reservations/{id}

    @GetMapping("/{reservationId}")
    public Reservation findById(@PathVariable long id) {
        return reservationsService.findById(id);
    }

    // PUT http://localhost:3001/reservations/{id} (+ body)

    @PutMapping("/{reservationId}")
    public Reservation findByIdAndUpdate(@PathVariable long id,
                                         @RequestBody Reservation body) {
        return reservationsService.findByIdAndUpdate(id, body);
    }

    // DELETE http://localhost:3001/reservations/{id}

    @DeleteMapping("/{reservationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) {
        reservationsService.findByIdAndDelete(id);
    }
}