package tn.sae.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.sae.auth.exceptions.UserAlreadyExistException;
import tn.sae.auth.exceptions.UserNotFoundException;
import tn.sae.auth.model.User;
import tn.sae.auth.service.UserService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUsers() throws IOException {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("No users found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) throws IOException {
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity("User already exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws IOException {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getbyusername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) throws IOException {
        try {
            return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity("User deleted successfully", HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByUsername(@RequestParam("username") String username) {
        List<User> users = userService.searchUsersByUsername(username);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity("No matching users found", HttpStatus.NOT_FOUND);
        }
    }
}
