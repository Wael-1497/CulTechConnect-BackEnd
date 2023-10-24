package com.example.exchangeprog.Controller;

import com.example.exchangeprog.Entity.programmeEchange;

import com.example.exchangeprog.service.ProgrammeEchangeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/programmes")
public class ExchangeprogController {


    ProgrammeEchangeService programmeExchangeControl;



    @PostMapping("/AddprogrammeExchange")
    public ResponseEntity<programmeEchange> ajouterProgrammeEchange(@RequestBody programmeEchange programmeEchange) {
        programmeEchange ajouter = programmeExchangeControl.ajouterProgrammeEchange(programmeEchange);
        return ResponseEntity.ok(ajouter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<programmeEchange> afficherProgrammeEchange(@PathVariable Long id) {
        programmeEchange programmeEchange = programmeExchangeControl.afficherProgrammeEchange(id);
        if (programmeEchange != null) {
            return ResponseEntity.ok(programmeEchange);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/afficher")
    public ResponseEntity<Page<programmeEchange>> afficherTousProgrammesEchange(Pageable pageable) {
        Page<programmeEchange> programmes = programmeExchangeControl.afficherTousProgrammesEchange(pageable);
        return ResponseEntity.ok(programmes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<programmeEchange> modifierProgrammeEchange(@PathVariable Long id, @RequestBody programmeEchange programmeEchange) {
        programmeEchange updatedProgramme = programmeExchangeControl.modifierProgrammeEchange(id, programmeEchange);
        if (updatedProgramme != null) {
            return ResponseEntity.ok(updatedProgramme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProgrammeEchange(@PathVariable Long id) {
        boolean deleted = programmeExchangeControl.supprimerProgrammeEchange(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
