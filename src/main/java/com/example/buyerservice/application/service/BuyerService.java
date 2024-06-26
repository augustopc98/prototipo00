package com.example.buyerservice.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyerservice.application.dto.BuyerDTO;
import com.example.buyerservice.application.mapper.BuyerMapper;
import com.example.buyerservice.domain.model.Buyer;
import com.example.buyerservice.domain.repository.BuyerRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerMapper buyerMapper;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
        this.buyerMapper = BuyerMapper.INSTANCE;
    }

    public BuyerDTO createBuyer(String fullName, String email, String phoneNumber, String address) {
        Buyer buyer = new Buyer(fullName, email, phoneNumber, address);
        return buyerMapper.toBuyerDTO(buyerRepository.save(buyer));
    }

    public BuyerDTO getBuyerById(int id) {
        Buyer buyer = buyerRepository.findById(id);
        return buyerMapper.toBuyerDTO(buyer);
    }

    public List<BuyerDTO> getAllBuyers() {
        return buyerRepository.findAll().stream()
                .map(buyerMapper::toBuyerDTO)
                .collect(Collectors.toList());
    }

    public BuyerDTO updateBuyer(int id, String fullName, String email, String phoneNumber, String address) {
        Buyer buyer = buyerRepository.findById(id);
        if (buyer != null) {
            buyer.setFullName(fullName);
            buyer.setEmail(email);
            buyer.setPhoneNumber(phoneNumber);
            buyer.setAddress(address);
            return buyerMapper.toBuyerDTO(buyerRepository.save(buyer));
        }
        return null;
    }

    public void deleteBuyer(int id) {
        buyerRepository.deleteById(id);
    }
}

