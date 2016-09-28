package ua.rud.pos.payment;

import ua.rud.pos.coin.Coin;
import ua.rud.pos.coin.Coins;

import java.util.ArrayList;
import java.util.List;

public final class CoinPayment implements Payment {
    private List<Coin> coins;

    public CoinPayment() {
        this.coins = new ArrayList<>();
    }

    /*Methods*/
    public void add(Coin coin) {
        coins.add(coin);
    }

    public List<Coin> getAll() {
        if (coins.isEmpty()) {
            return coins;
        }

        List<Coin> coinsToReturn = coins;
        coins = new ArrayList<>();
        return coinsToReturn;
    }

    @Override
    public long value() {
        long value = 0;
        for (Coin coin : coins) {
            value += coin.getValue();
        }
        return value;
    }
}
