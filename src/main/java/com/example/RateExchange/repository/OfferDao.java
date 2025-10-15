package com.example.RateExchange.repository;

import com.example.RateExchange.dto.OfferFilterDto;
import com.example.RateExchange.dto.UserFilterDto;
import com.example.RateExchange.entity.Offer;
import com.example.RateExchange.entity.User;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User: Vu
 * Date: 30.09.2025
 * Time: 11:27
 */
@Component
public class OfferDao {
    private final OfferRepository offerRepository;

    public OfferDao(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    private Specification<Offer> getUserSpecification(OfferFilterDto filter) {
        return (Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->
                criteriaBuilder.and(getUserPredicateList(filter, root, criteriaBuilder).toArray(new Predicate[0]));
    }

    private List<Predicate> getUserPredicateList(
            OfferFilterDto filter, Root<Offer> root, CriteriaBuilder criteriaBuilder
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getName())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%".concat(filter.getName().toLowerCase()).concat("%")));
        }




        return predicates;
    }

}
