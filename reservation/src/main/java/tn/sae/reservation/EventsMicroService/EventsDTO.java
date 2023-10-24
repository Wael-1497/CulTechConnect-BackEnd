package tn.sae.reservation.EventsMicroService;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class EventsDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

}
