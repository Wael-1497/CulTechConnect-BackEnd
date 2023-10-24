package tn.sae.reservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.sae.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation,Long> {
}
