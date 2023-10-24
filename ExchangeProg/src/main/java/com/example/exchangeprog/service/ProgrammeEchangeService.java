package com.example.exchangeprog.service;

import com.example.exchangeprog.Entity.programmeEchange;
import com.example.exchangeprog.repository.ProgrammeEchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ProgrammeEchangeService implements ProgrammeEchangeIMP{
    @Autowired
    ProgrammeEchangeRepository programmeEchangeRepository;

   @Override
   public programmeEchange ajouterProgrammeEchange(programmeEchange programmeEchange) {
       return programmeEchangeRepository.save(programmeEchange);
   }
   @Override
   public programmeEchange afficherProgrammeEchange(Long id) {
       Optional<programmeEchange> programmeEchangeOptional = programmeEchangeRepository.findById(id);
       return programmeEchangeOptional.orElse(null);
   }

    @Override
    public Page<programmeEchange> afficherTousProgrammesEchange(java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public Page<programmeEchange> afficherTousProgrammesEchange(Pageable pageable) {
        return programmeEchangeRepository.findAll(pageable);
    }

    @Override
    public programmeEchange modifierProgrammeEchange(Long id, programmeEchange programmeEchange) {
        Optional<programmeEchange> existingProgramme = programmeEchangeRepository.findById(id);
        if (existingProgramme.isPresent()) {
            programmeEchange.setId(id);
            return programmeEchangeRepository.save(programmeEchange);
        }
        return null;
    }


   @Override
    public boolean supprimerProgrammeEchange(Long id) {
        if (programmeEchangeRepository.existsById(id)) {
            programmeEchangeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
