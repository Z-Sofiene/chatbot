package tn.i_sante.bpo.chatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.i_sante.bpo.chatbot.entity.Reclamation;
import tn.i_sante.bpo.chatbot.repository.ReclamationRepository;
import tn.i_sante.bpo.chatbot.service.ReclamationService;

import java.util.List;

@Service
@Transactional
public class ReclamationServiceImp implements ReclamationService {
    @Autowired
    private ReclamationRepository repositoryReclamation;

    public Reclamation addReclamation(Reclamation reclamation) {
        return repositoryReclamation.save(reclamation);
    }

    @Override
    public void deleteReclamationById(long id_reclamation) {
    	repositoryReclamation.deleteById(id_reclamation);
    }
    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return repositoryReclamation.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(long id_reclamation) {
        return repositoryReclamation.findById(id_reclamation).orElse(null);
    }

    @Override
    public Reclamation getReclamationByDossierId(long num_consultation) {
        return repositoryReclamation.findByDossierId(num_consultation);
    }

    public List<Reclamation> getAllReclamationsByAdherentId(long matricule_adherent) {
        return repositoryReclamation.findAllByAdherentId(matricule_adherent);
    }
    public List<Reclamation> getAllReclamations() {
        return repositoryReclamation.findAll();
    }
}
