package com.example.JavaSpringPostgreSQL.services;

import com.example.JavaSpringPostgreSQL.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.JavaSpringPostgreSQL.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (user.getCars() != null) {
            user.getCars().forEach(car -> car.setUser(user));
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setEmail(userDetails.getEmail());
                    if (userDetails.getCars() != null) {
                        userDetails.getCars().forEach(car -> car.setUser(user));
                        user.setCars(userDetails.getCars());
                    }
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByIdWithCars(Long id) {
        return userRepository.findByIdWithCars(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
