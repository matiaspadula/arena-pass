package com.estadiovirtual.core.user.application;

import com.estadiovirtual.core.user.domain.User;
import com.estadiovirtual.core.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public List<User> findAll(){return userRepository.findAll();}

    public void deleteById(Long id){userRepository.deleteById(id);}

    public User updateUser(Long id, User userDetails){
        return userRepository.findById(id)
                .map(u ->{
                    u.setName(userDetails.getName());
                    u.setLastName(userDetails.getLastName());
                    return userRepository.save(userDetails);
                })
                .orElse(null);
    }
}