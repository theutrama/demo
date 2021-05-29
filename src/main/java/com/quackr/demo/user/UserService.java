package com.quackr.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id "+ userId+ " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String email, String username) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with "+ userId + " does not exist"));


        if(firstName != null && firstName.length()>0 && !Objects.equals(user.getFirst_name(), firstName)){
            user.setFirst_name(firstName);
        }

        if(lastName != null && lastName.length()>0 && !Objects.equals(user.getLast_name(), lastName)){
            user.setLast_name(lastName);
        }

        if(email != null && email.length()>0 && !Objects.equals(user.getEmail(),email)){
            Optional<User> optionalUser = userRepository.findUserByEmail(email);
            if(optionalUser.isPresent()){
                throw new IllegalStateException("email is already taken");
            }
            user.setEmail(email);
        }

        if(username != null && username.length()>0 && !Objects.equals(user.getUsername(),username)){
            //usernames can be used more than once
            System.out.println("username update");
            user.setUsername(username);
        }
    }
}
