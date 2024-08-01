package tn.i_sante.bpo.chatbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.i_sante.bpo.chatbot.entity.Admin;
import tn.i_sante.bpo.chatbot.repository.AdminRepository;
import tn.i_sante.bpo.chatbot.service.AdminService;

import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin getAdminById(long matricule_admin) {
        return adminRepository.findById(matricule_admin).orElse(null);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return null;
    }

    @Override
    public void deleteAdmin(long matricule_admin) {

    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return List.of();
    }
}
