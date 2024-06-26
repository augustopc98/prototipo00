package com.example.buyerservice.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.buyerservice.application.dto.BuyerDTO;
import com.example.buyerservice.domain.model.Buyer;

@Mapper
public interface BuyerMapper {
    BuyerMapper INSTANCE = Mappers.getMapper(BuyerMapper.class);

    BuyerDTO toBuyerDTO(Buyer buyer);
    Buyer toBuyer(BuyerDTO buyerDTO);
}

