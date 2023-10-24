package tn.sae.reservation.EventsMicroService;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Data
public class Events{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date date;
    private String location;
    private String description;


}
