package com.app.demo.controller;

import com.app.demo.model.Buy;
import com.app.demo.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buys")
public class BuyController {
    @Autowired
    private BuyService buyService;

    @GetMapping
    public List<Buy> getAllBuys() {
        return buyService.getAllBuys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buy> getBuyById(@PathVariable Long id) {
        Optional<Buy> buy = buyService.getBuyById(id);
        return buy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Buy createBuy(@RequestBody Buy buy) {
        return buyService.saveBuy(buy);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuy(@PathVariable Long id) {
        buyService.deleteBuy(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buy> updateBuy(@PathVariable Long id, @RequestBody Buy buyDetails) {
        Optional<Buy> optionalBuy = buyService.getBuyById(id);
        if (optionalBuy.isPresent()) {
            Buy buy = optionalBuy.get();
            buy.setItems(buyDetails.getItems());
            return ResponseEntity.ok(buyService.saveBuy(buy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}