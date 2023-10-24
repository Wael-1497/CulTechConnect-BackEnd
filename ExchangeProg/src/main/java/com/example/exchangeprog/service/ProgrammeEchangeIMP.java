package com.example.exchangeprog.service;

import com.example.exchangeprog.Entity.programmeEchange;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;

@Component
public interface ProgrammeEchangeIMP {
    programmeEchange ajouterProgrammeEchange(programmeEchange programmeEchange);

    programmeEchange afficherProgrammeEchange(Long id);

    Page<programmeEchange> afficherTousProgrammesEchange(Pageable pageable);

    Page<programmeEchange> afficherTousProgrammesEchange(org.springframework.data.domain.Pageable pageable);

    programmeEchange modifierProgrammeEchange(Long id, programmeEchange programmeEchange);

    boolean supprimerProgrammeEchange(Long id);
}
