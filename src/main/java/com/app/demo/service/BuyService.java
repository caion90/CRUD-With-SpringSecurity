package com.app.demo.service;

import com.app.demo.model.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {
    @Autowired
    private com.app.demo.repository.buyRepository buyRepository;

    public List<Buy> getAllBuys() {
        return buyRepository.findAll();
    }

    public Optional<Buy> getBuyById(Long id) {
        return buyRepository.findByBuyId(id);
    }

    public Buy saveBuy(Buy buy) {
        return buyRepository.save(buy);
    }

    public void deleteBuy(Long id) {
        buyRepository.deleteById(id);
    }
}