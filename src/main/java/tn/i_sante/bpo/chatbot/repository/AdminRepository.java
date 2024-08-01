package tn.i_sante.bpo.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.i_sante.bpo.chatbot.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}