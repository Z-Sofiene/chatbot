package tn.i_sante.bpo.chatbot.service;

import java.util.List;

import tn.i_sante.bpo.chatbot.entity.Reclamation;

public interface ReclamationService {

    Reclamation addReclamation(Reclamation reclamation);

    void deleteReclamationById(long id_reclamation);

    Reclamation updateReclamation(Reclamation reclamation);

    Reclamation getReclamationById(long id_reclamation);

    Reclamation getReclamationByDossierId(long num_consultation);

    List<Reclamation> getAllReclamationsByAdherentId(long matricule_adherent);

    List<Reclamation> getAllReclamations();

}
