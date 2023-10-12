package tn.sae.partnership.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sae.partnership.entity.Partnership;
import tn.sae.partnership.service.PartnershipService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/partnership")
@RequiredArgsConstructor
public class PartnershipController {
    @Autowired
    PartnershipService partnershipService;

    @PostMapping("/add-part/{idEvenement}")
    @ResponseBody
    void addPartenariat(@RequestBody Partnership partenaire, @PathVariable int idEvenement) {
        partnershipService.addPartenariat(partenaire, idEvenement);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/all-part")
    @ResponseBody
    List<Partnership> getAllPartenariats(){
        return partnershipService.getAllPartenariats();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/part/{idPartnership}")
    @ResponseBody
    Partnership getPartnershipById(@PathVariable("idPartnership") Integer idPartnership){
        return partnershipService.getPartnershipById(idPartnership);
    }
}
