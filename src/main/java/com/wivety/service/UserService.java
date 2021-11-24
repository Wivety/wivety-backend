package com.wivety.service;
import com.wivety.models.AuthenticationModel;
import com.wivety.models.Profile;
import com.wivety.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Profile create (Profile User) {
        return userRepository.save(User);
    }

    public Profile authenticate (AuthenticationModel authenticationModel) throws Exception {
        Profile user = userRepository.getByEmail(authenticationModel.getEmail());
        if (!user.getPassword().equals(authenticationModel.getPassword())) throw new Exception("Incorrect Password");
        return user;
    }

    public List<Profile> getAllUsers (){
        return userRepository.findAll();
    }

    public void delete (Profile User) {
        userRepository.delete(User);
    }

    public Profile findById (String id) {
        return userRepository.getById(id);
    }
}
