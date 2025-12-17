package com.bentesdev.financemanager.domain.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String email, String rawPassword){

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        String passowordHash = passwordEncoder.encode(rawPassword);

        User user = new User(email, rawPassword);
        userRepository.save(user);
    }
}
