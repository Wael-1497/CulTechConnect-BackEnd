package com.example.exchangeprog.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "programmes_echange")
public class programmeEchange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProgramme;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private int dureeSemaines;
    private String typeProgramme;
    private String responsableProgramme;


}
