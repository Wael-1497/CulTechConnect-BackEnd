package tn.sae.reservation.service;

import tn.sae.reservation.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation updateReservation(Long idRes, Reservation reservation);
   // Events getEventById(Integer idEvent);

    Reservation getReservationById(Long idRes);
    void deleteReservation(Long idRes);
    // Add other reservation-related methods as needed
}
