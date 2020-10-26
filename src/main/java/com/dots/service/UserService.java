package com.dots.service;

import com.dots.persistence.model.User;
import com.dots.persistence.repo.UserRepository;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers()
    {
        List<User> result = (List<User>) userRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }


    public User createOrUpdateUser(User user)
    {

        long maybeNull = user.getUser_id();
        if(maybeNull == 0)
        {
            user = userRepository.save(user);

            return user;
        }
        else
        {
            Optional<User> user1 = userRepository.findById(user.getUser_id());

            if(user1.isPresent())
            {
                User newEntity = user1.get();
                newEntity.setEmail(user.getEmail());
                newEntity. setUsername(user.getUsername());
                newEntity.setPassword(user.getPassword());

                newEntity = userRepository.save(newEntity);

                return newEntity;
            } else {
                user = userRepository.save(user);

                return user;
            }
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
        {
            userRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

}
