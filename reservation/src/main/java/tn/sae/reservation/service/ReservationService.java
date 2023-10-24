package tn.sae.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.sae.reservation.EventsMicroService.EventsDTO;
import tn.sae.reservation.entity.Reservation;
import tn.sae.reservation.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService implements IReservationService {



    @Autowired
    private ReservationRepository reservationRepository;



    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation getReservationById(Long idReser) {
        return reservationRepository.findById(idReser).orElse(null);
    }

    @Override
    public Reservation updateReservation(Long idReser, Reservation reservation) {
        if (reservationRepository.existsById(idReser)) {
            reservation.setIdRes(idReser);
            return reservationRepository.save(reservation);
        }
        return null; // Handle not found case
    }
    @Override
    public void deleteReservation(Long idReser) {
        reservationRepository.deleteById(idReser);
    }

    // Implement other reservation-related methods here
}
