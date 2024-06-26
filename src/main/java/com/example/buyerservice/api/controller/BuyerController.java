package com.example.buyerservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.buyerservice.application.dto.BuyerDTO;
import com.example.buyerservice.application.service.BuyerService;
import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping
    public BuyerDTO createBuyer(@RequestParam String fullName, @RequestParam String email,
                                @RequestParam String phoneNumber, @RequestParam String address) {
        return buyerService.createBuyer(fullName, email, phoneNumber, address);
    }

    @GetMapping("/{id}")
    public BuyerDTO getBuyerById(@PathVariable int id) {
        return buyerService.getBuyerById(id);
    }

    @GetMapping
    public List<BuyerDTO> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @PutMapping("/{id}")
    public BuyerDTO updateBuyer(@PathVariable int id, @RequestParam String fullName,
                                @RequestParam String email, @RequestParam String phoneNumber,
                                @RequestParam String address) {
        return buyerService.updateBuyer(id, fullName, email, phoneNumber, address);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable int id) {
        buyerService.deleteBuyer(id);
    }
}
