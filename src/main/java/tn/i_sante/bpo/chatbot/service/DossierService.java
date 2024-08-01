package tn.i_sante.bpo.chatbot.service;

import java.util.List;
import java.util.Optional;

import tn.i_sante.bpo.chatbot.entity.Dossier;


public interface DossierService {
    List<Dossier> getAllDossiersByMaladeEnChargeId(long id_malade_en_charge);
    Optional<Dossier> getDossierByNumConsultation(long numConsultation);
    List<Dossier> getAllDossiersByAdherentMatricule(long matricule);
    Dossier addDossier(Dossier dossier);
    void deleteDossierByNumConsultation(long numConsultation);
    Dossier updateDossier(Dossier dossier);
}

