package com.eventbooking.dao;

import com.eventbooking.model.User;
import java.util.List;

public interface UserDAO {

    boolean addUser(User user);

    User getUserById(int userId);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    boolean updateUser(User user);

    boolean deleteUser(int userId);
}