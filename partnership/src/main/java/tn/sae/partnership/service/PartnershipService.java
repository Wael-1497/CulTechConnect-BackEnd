package tn.sae.partnership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sae.partnership.entity.Partnership;
import tn.sae.partnership.repository.PartnershipRepository;

import java.util.List;

@Service
public class PartnershipService implements IpartnershipService {
    @Autowired
    PartnershipRepository partnershipRepository;
    @Override
    public void addPartenariat(Partnership partenaire, int idEvenement) {
//        Récupérer l'événement associé à l'id
//        Evenement evenement = evenementRepository.findById(idEvenement).orElse(null);
        if (idEvenement != 0) { // !=NULL
            // Associer l'événement au partenariat
            partenaire.setIdEvenement(idEvenement);
            partnershipRepository.save(partenaire);
        } else {
            throw new RuntimeException("L'événement avec l'ID " + idEvenement + " n'a pas été trouvé.");
        }

    }

    @Override
    public List<Partnership> getAllPartenariats() {
        return partnershipRepository.findAll();
    }

}
