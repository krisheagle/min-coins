package com.mincoins.mincoins.controller;

import com.mincoins.mincoins.service.CoinChangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CoinChangeController {

    private CoinChangeService coinChangeService;

    public CoinChangeController(CoinChangeService coinChangeService) {
        this.coinChangeService = coinChangeService;
    }

    @GetMapping("/getchange/{change}")
    public int minCoinsPossible(@PathVariable("change") int amount) {
        return coinChangeService.getMinCoins(amount);
    }

    @PostMapping("/configure/coins")
    public ResponseEntity configureCoins(@RequestBody Map<Double,Integer> coinsFrequency) {
       //TODO: we can get coins and their frequency from request hardcoding coins for now.
        return ResponseEntity.ok("Added coins");
    }
}
