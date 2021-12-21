package com.example.matvaretabellen.service;

import com.example.matvaretabellen.exception.UserNotFoundException;
import com.example.matvaretabellen.model.User;
import com.example.matvaretabellen.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        user.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }
}
