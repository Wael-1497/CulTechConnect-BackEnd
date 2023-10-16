package tn.sae.auth.service;

import tn.sae.auth.exceptions.UserAlreadyExistException;
import tn.sae.auth.exceptions.UserNotFoundException;
import tn.sae.auth.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws UserNotFoundException;
    User addUser(User user) throws UserAlreadyExistException;
    User getUserById(Long id) throws UserNotFoundException;
    User getUserByUsername(String username) throws UserNotFoundException;
    User updateUser(Long id, User user) throws UserNotFoundException;
    void deleteUser(Long id) throws UserNotFoundException;
    List<User> searchUsersByUsername(String username);
}
