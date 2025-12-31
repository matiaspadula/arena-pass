package com.estadiovirtual.core.user.application;

import com.estadiovirtual.core.user.domain.User;
import com.estadiovirtual.core.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Acá podríamos validar si el email ya existe, validar la contraseña, etc.
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}