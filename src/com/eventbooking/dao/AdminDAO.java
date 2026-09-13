package com.eventbooking.dao;

import com.eventbooking.model.Admin;
import java.util.List;

public interface AdminDAO {

    boolean addAdmin(Admin admin);

    Admin getAdminById(int adminId);

    Admin getAdminByEmail(String email);

    List<Admin> getAllAdmins();

    boolean updateAdmin(Admin admin);

    boolean deleteAdmin(int adminId);
}