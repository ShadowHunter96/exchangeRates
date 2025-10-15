package com.example.RateExchange.service;

import com.example.RateExchange.dto.OfferDto;
import com.example.RateExchange.entity.Offer;
import com.example.RateExchange.exception.NotFoundInDbException;
import com.example.RateExchange.repository.OfferRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User: Vu
 * Date: 30.09.2025
 * Time: 11:23
 */
@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferDtoMapper offerDtoMapper;

    public OfferService(OfferRepository offerRepository, OfferDtoMapper offerDtoMapper) {
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
    }


    @Transactional
    public Offer create(Offer offer) {return offerRepository.save(offer);}

    public List<OfferDto> getAllOffersDto(){
        return offerRepository.findAll().stream().map(offerDtoMapper).collect(Collectors.toList());
    }


    public Offer getById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDbException("Offer not found, id=" + id));
    }

    @Transactional(readOnly = true)
    public Page<Offer> list(Pageable pageable) {
        return (Page<Offer>) offerRepository.findAll(pageable);
    }

    @Transactional
    public Offer update(Long id, Offer updated) {
        Offer existing = offerRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDbException("Offer not found, id=" + id));

        existing.setName(updated.getName());
        existing.setPriceWithoutVat(updated.getPriceWithoutVat());
        existing.setOfferDate(updated.getOfferDate());
        existing.setMarketUrl(updated.getMarketUrl());
        existing.setPriceAssurance(updated.getPriceAssurance());
        existing.setSent(updated.getSent());
        existing.setDeleted(updated.getDeleted());
        existing.setLastUpdate(updated.getLastUpdate());
        existing.setUser(updated.getUser());

        return offerRepository.save(existing);
    }

    /**
     * DELETE
     */
    @Transactional
    public void delete(Long id) {
        if (!offerRepository.existsById(id)) {
            throw new NotFoundInDbException("Offer not found, id=" + id);
        }
        offerRepository.deleteById(id);
    }
}