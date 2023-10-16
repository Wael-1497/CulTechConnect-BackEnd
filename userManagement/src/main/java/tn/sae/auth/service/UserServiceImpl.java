package tn.sae.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sae.auth.exceptions.UserAlreadyExistException;
import tn.sae.auth.exceptions.UserNotFoundException;
import tn.sae.auth.model.User;
import tn.sae.auth.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException();
        } else {
            return users;
        }
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        Optional<User> existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistException();
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User updateUser(Long id, User newUser) throws UserNotFoundException {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setUserName(newUser.getUserName());
            userToUpdate.setPassword(newUser.getPassword());
            // Set other fields as needed
            return userRepository.save(userToUpdate);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        Optional<User> userToDelete = userRepository.findById(id);
        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> searchUsersByUsername(String username) {
        return userRepository.findByUserNameContaining(username);
    }

}
