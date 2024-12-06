package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;
    @Operation(description = "récupérer toutes les reservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservation() {
        List<Reservation> listReservation = reservationService.getReservations();
        return listReservation;
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation getReservation(@PathVariable("reservation-id") Long reservationId) {
        Reservation reservation = reservationService.GetReservationById(reservationId);
        return reservation;
    }

    @PostMapping ("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        Reservation reservation1 = reservationService.addReservation(reservation);
        return reservation1;
    }

    @DeleteMapping ("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @PutMapping ("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        Reservation reservation1 = reservationService.updateReservation(reservation);
        return reservation1;
    }
}