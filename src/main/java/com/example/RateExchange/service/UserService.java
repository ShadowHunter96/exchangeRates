package com.example.RateExchange.service;

import com.example.RateExchange.dto.UserFilterDto;
import com.example.RateExchange.entity.Offer;
import com.example.RateExchange.entity.User;
import com.example.RateExchange.repository.OfferRepository;
import com.example.RateExchange.repository.UserDao;
import com.example.RateExchange.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final OfferRepository offerRepository;

    public UserService (UserRepository userRepository, UserDao userDao, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.userDao = userDao;
        this.offerRepository = offerRepository;
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


    @Transactional
    public User assignOfferToUser(Long userId, Long offerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User " + userId + " not found"));

        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer " + offerId + " not found"));


        if (offer.getUser() != null && !offer.getUser().getId().equals(userId)) {
            throw new IllegalStateException("Offer " + offerId + " je už přiřazen uživateli " + offer.getUser().getId());
        }

        Offer old = user.getOffer();


        user.setOffer(offer);
        offer.setUser(user);

        return userRepository.save(user);
    }







    }

