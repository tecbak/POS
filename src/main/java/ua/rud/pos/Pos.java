package ua.rud.pos;

import ua.rud.pos.coin.Coin;
import ua.rud.pos.coin.Coins;
import ua.rud.pos.payment.CoinPayment;
import ua.rud.pos.product.Product;
import ua.rud.pos.product.Products;

import java.util.List;

public final class Pos {
    private CoinPayment coins = new CoinPayment();
    private final Sale sale = new Sale();

    public boolean addProduct(String name) {
        try {
            Products product = Products.valueOf(name.toUpperCase());
            sale.addProduct(product);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void clear() {
        sale.clear();
    }


    public void insertCoin(Coin coin) {
        coins.add(coin);
    }

    public long valueOfCoins() {
        return coins.value();
    }


    public void pay() {
        long price = sale.total();
        long paid = coins.value();

        if (paid >= price) {
            sale.pay();
            coins = calculateChange(price, paid);
        }
    }

    private CoinPayment calculateChange(long price, long paid) {
        long change = paid - price;
        CoinPayment coins = new CoinPayment();

        while (change > 0) {
            for (Coins coin : Coins.values()) {
                long value = coin.getValue();
                if (value <= change) {
                    coins.add(coin);
                    change -= value;
                    break;
                }
            }
        }
        return coins;
    }

    public List<Product> getProducts() {
        return sale.getProducts();
    }

    public List<Coin> returnCoins() {
        List<Coin> change = coins.getAll();

        return change;
    }
}
