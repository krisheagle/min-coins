package com.mincoins.mincoins.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoinChangeService {

    private static Map<Integer,Integer> coinFreq;

    static {
        coinFreq = new HashMap<>();
        coinFreq.put(1,100);
        coinFreq.put(2,100);
        coinFreq.put(5,100);
    }

    public int getMinCoins(int amount) {
        if (amount < 1) return 0;
        return coinChange(amount, new int[amount]);
    }

    public int coinChange(int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coinFreq.keySet()) {
            int res = coinChange(rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
