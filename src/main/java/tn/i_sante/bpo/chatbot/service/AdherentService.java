package tn.i_sante.bpo.chatbot.service;

import tn.i_sante.bpo.chatbot.entity.Adherent;
import java.util.List;
import java.util.Optional;

public interface AdherentService {
    Optional<Adherent> getAdherentById(long matricule);
    Adherent addAdherent(Adherent adherent);
    void deleteAdherentById(long matricule);
    Adherent updateAdherent(Adherent adherent);
    List<Adherent> getAllAdherents();

}
