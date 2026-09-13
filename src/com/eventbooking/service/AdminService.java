package com.eventbooking.service;

import java.util.List;

import com.eventbooking.dao.AdminDAO;
import com.eventbooking.daoimpl.AdminDAOImpl;
import com.eventbooking.exception.UserNotFoundException;
import com.eventbooking.model.Admin;
import com.eventbooking.util.IDGenerator;

public class AdminService {

    private final AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO = new AdminDAOImpl();
    }

    public boolean registerAdmin(Admin admin) {

        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be null");
        }

        if (admin.getName() == null ||
                admin.getName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Admin name cannot be empty"
            );
        }

        if (admin.getEmail() == null ||
                admin.getEmail().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Admin email cannot be empty"
            );
        }

        if (admin.getPassword() == null ||
                admin.getPassword().length() < 6) {

            throw new IllegalArgumentException(
                    "Password must contain at least 6 characters"
            );
        }

        if (adminDAO.getAdminByEmail(admin.getEmail()) != null) {
            throw new IllegalArgumentException(
                    "Admin with this email already exists"
            );
        }

        admin.setUserId(IDGenerator.generateAdminId());

        return adminDAO.addAdmin(admin);
    }

    public Admin login(String email, String password) {

        Admin admin = adminDAO.getAdminByEmail(email);

        if (admin == null) {
            throw new UserNotFoundException(
                    "Admin not found with email: " + email
            );
        }

        if (!admin.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return admin;
    }

    public Admin getAdminById(int adminId) {

        Admin admin = adminDAO.getAdminById(adminId);

        if (admin == null) {
            throw new UserNotFoundException(
                    "Admin not found with ID: " + adminId
            );
        }

        return admin;
    }

    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    public boolean updateAdmin(Admin admin) {

        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be null");
        }

        getAdminById(admin.getUserId());

        return adminDAO.updateAdmin(admin);
    }

    public boolean deleteAdmin(int adminId) {

        getAdminById(adminId);

        return adminDAO.deleteAdmin(adminId);
    }
}