package tn.sae.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sae.reservation.entity.Reservation;
import tn.sae.reservation.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/{idReser}")
    public Reservation getReservationById(@PathVariable Long idReser) {
        return reservationService.getReservationById(idReser);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        // Implement a method in the service to get all reservations
        return reservationService.getAllReservations();
    }

    @PutMapping("/{idReser}")
    public Reservation updateReservation(@PathVariable Long idReser, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(idReser, reservation);
    }

    @DeleteMapping("/{idReser}")
    public void deleteReservation(@PathVariable Long idReser) {
        reservationService.deleteReservation(idReser);
    }

    // Implement other reservation-related endpoints as needed

}
