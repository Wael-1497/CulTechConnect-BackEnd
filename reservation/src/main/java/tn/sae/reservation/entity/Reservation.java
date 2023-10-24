package tn.sae.reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.sae.reservation.EventsMicroService.EventsDTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRes;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "events_id_events")  // This column should reference the primary key of EventsDTO
    private EventsDTO events;

}
