package com.digitaltrio.listdoapi.data.services.userService;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.exceptions.EmailNotAvailableException;
import com.digitaltrio.listdoapi.data.repositories.UserRepository;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.user.NewUserRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No User found with ID: " + id));
    }

    @Override
    public User createUser(NewUserRequest userRequest) throws EmailNotAvailableException {
        if(!checkForEmailAvailability(userRequest.getEmail())) {
            throw new EmailNotAvailableException("Email is already taken");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(Constants.encodeStrength);
        User user = new User(userRequest);
        user.setPassword(encoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) throws EntityNotFoundException {
        try {
            getUser(id);
            userRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) throws EntityNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new EntityNotFoundException("Couldn't find User with email: " + email));
    }

    @Override
    public Boolean checkForEmailAvailability(String email) {
        return !(userRepository.existsByEmail(email));
    }
}
