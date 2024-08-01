package tn.i_sante.bpo.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tn.i_sante.bpo.chatbot.entity.Adherent;
import tn.i_sante.bpo.chatbot.entity.MaladeEnCharge;

@Repository
@RepositoryRestResource
public interface MaladeEnChargeRepository extends JpaRepository<MaladeEnCharge, Long> {
    @Query("SELECT a FROM Adherent a JOIN MaladeEnCharge m ON a.matricule = m.adherent.matricule WHERE m.id = ?1")
    Adherent findAdherentByMaladeEnChargeId(long maladeEnChargeId);
    @Query("select m from MaladeEnCharge m where m.adherent.matricule = ?1")
    List<MaladeEnCharge> findAllMaladesEnChargeByAdherentMatricule(long matriculeAdherent);
}
