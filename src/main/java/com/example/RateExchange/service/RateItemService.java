package com.example.RateExchange.service;

import com.example.RateExchange.dto.RateItemDto;
import com.example.RateExchange.entity.RateItem;
import com.example.RateExchange.exception.NotFoundInDbException;
import com.example.RateExchange.exception.UpstreamServiceException;
import com.example.RateExchange.repository.RateItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RateItemService {

    private final RateItemRepository rateItemRepository;
    private final ErsteRatesService ersteRates;

    public RateItemService(final RateItemRepository rateItemRepository, final ErsteRatesService ersteRates) {
        this.rateItemRepository = rateItemRepository;
        this.ersteRates = ersteRates;
    }

    public List<RateItemDto> findAll() {
        final List<RateItem> rateItems = rateItemRepository.findAll(Sort.by("id"));
        return rateItems.stream()
                .map(rateItem -> mapToDTO(rateItem, new RateItemDto()))
                .toList();
    }


    @Transactional
    public List<RateItemDto> getRates(final boolean usedb) {
        var remoteRates = ersteRates.fetchRates();
        if (remoteRates == null || remoteRates.isEmpty()) {
            throw new UpstreamServiceException("No data from API.");
        }

        if (usedb) {
            rateItemRepository.deleteAllInBatch();
            rateItemRepository.saveAll(remoteRates.stream()
                    .map(this::mapToEntity)
                    .toList());
            return findAll();
        } else {
            return remoteRates;
        }
    }





    private RateItemDto mapToDTO(RateItem rateItem, RateItemDto rateItemDTO) {

        rateItemDTO.setShortName(rateItem.getShortName());
        rateItemDTO.setValidFrom(rateItem.getValidFrom());
        rateItemDTO.setName(rateItem.getName());
        rateItemDTO.setCountry(rateItem.getCountry());
        rateItemDTO.setMove(rateItem.getMove());
        rateItemDTO.setAmount(rateItem.getAmount());
        rateItemDTO.setValBuy(rateItem.getValBuy());
        rateItemDTO.setValSell(rateItem.getValSell());
        rateItemDTO.setCurrMid(rateItem.getCurrMid());
        rateItemDTO.setVersion(rateItem.getVersion());
        rateItemDTO.setCnbMid(rateItem.getCnbMid());
        rateItemDTO.setEcbMid(rateItem.getEcbMid());
        return rateItemDTO;
    }

    private RateItem mapToEntity(RateItemDto rateItemDTO, RateItem rateItem) {
        rateItem.setShortName(rateItemDTO.getShortName());
        rateItem.setValidFrom(rateItemDTO.getValidFrom());
        rateItem.setName(rateItemDTO.getName());
        rateItem.setCountry(rateItemDTO.getCountry());
        rateItem.setMove(rateItemDTO.getMove());
        rateItem.setAmount(rateItemDTO.getAmount());
        rateItem.setValBuy(rateItemDTO.getValBuy());
        rateItem.setValSell(rateItemDTO.getValSell());
        rateItem.setCurrMid(rateItemDTO.getCurrMid());
        rateItem.setVersion(rateItemDTO.getVersion());
        rateItem.setCnbMid(rateItemDTO.getCnbMid());
        rateItem.setEcbMid(rateItemDTO.getEcbMid());
        return rateItem;
    }

    private RateItem mapToEntity(RateItemDto dto) {
        return mapToEntity(dto, new RateItem());
    }


}
