package tn.i_sante.bpo.chatbot.service;

import tn.i_sante.bpo.chatbot.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin getAdminById(long matricule_admin);
    Admin addAdmin(Admin admin);
    void deleteAdmin(long matricule_admin);
    Admin updateAdmin(Admin admin);
    List<Admin> getAllAdmins();

}
