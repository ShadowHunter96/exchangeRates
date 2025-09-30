package com.example.RateExchange.service;

import com.example.RateExchange.dto.UserFilterDto;
import com.example.RateExchange.entity.User;
import com.example.RateExchange.repository.UserDao;
import com.example.RateExchange.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by User: Vu
 * Date: 28.09.2025
 * Time: 20:58
 */
@Service
public class UserService {
    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){ return userRepository.findAll();};

    public Optional<User> saveUser(User usertoSave){
        userRepository.save(usertoSave);
        return userRepository.findByLogin(usertoSave.getLogin());
    }

    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getByFirstName(String firstName) {
        return userRepository.findByFirstNameIgnoreCase(firstName);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Page<User> findUserPage(UserFilterDto filter){return userDao.findUserPage(filter);}







}

