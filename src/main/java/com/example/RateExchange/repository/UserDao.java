package com.example.RateExchange.repository;

import com.example.RateExchange.dto.UserFilterDto;
import com.example.RateExchange.entity.User;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User: Vu
 * Date: 29.09.2025
 * Time: 21:00
 */
@Component
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;}

    private Specification<User> getUserSpecification(UserFilterDto filter) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                criteriaBuilder.and(getUserPredicateList(filter, root, criteriaBuilder).toArray(new Predicate[0]));
    }

    private List<Predicate> getUserPredicateList(
            UserFilterDto filter, Root<User> root, CriteriaBuilder criteriaBuilder
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getFirstName())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%".concat(filter.getFirstName().toLowerCase()).concat("%")));
        }

        if (!StringUtils.isEmpty(filter.getLastName())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%".concat(filter.getLastName().toLowerCase()).concat("%")));
        }

        if (!StringUtils.isEmpty(filter.getLogin())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("login")), "%".concat(filter.getLogin().toLowerCase()).concat("%")));
        }

        return predicates;
    }

    public Page<User> findUserPage(UserFilterDto userFilterDto) {
        Page<User> userEntityPage = userRepository.findAll(getUserSpecification(userFilterDto),
                PageRequest.of(userFilterDto.getPage(), userFilterDto.getSize(),
                        Sort.by(userFilterDto.getOrderList())));

        return new PageImpl<>(userEntityPage.getContent(), PageRequest.of(userFilterDto.getPage(),
                userFilterDto.getSize(), Sort.by(userFilterDto.getOrderList())),
                userEntityPage.getTotalElements());
    }
}

