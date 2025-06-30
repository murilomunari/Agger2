package com.agger.Service;

import com.agger.DTO.UserDTO;
import com.agger.Exception.UserException;
import com.agger.Model.User;
import com.agger.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDTO data) {

        Optional<User> nameExist = userRepository.findByName(data.name());

        if (nameExist.isPresent()) {
            throw new UserException("Usuário ja cadastrado");
        }

        User user = new User();
        user.setName(data.name());
        user.setPosition(data.position());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
