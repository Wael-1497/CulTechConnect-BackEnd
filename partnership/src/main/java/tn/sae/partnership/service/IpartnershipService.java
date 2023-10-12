package tn.sae.partnership.service;

import tn.sae.partnership.entity.Partnership;

import java.util.List;

public interface IpartnershipService {
    void addPartenariat(Partnership partenaire, int idEvenement);
    List<Partnership> getAllPartenariats();
    Partnership getPartnershipById(int idPartnership);

}
