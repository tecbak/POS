package ua.rud;

import ua.rud.pos.Pos;
import ua.rud.pos.coin.Coin;
import ua.rud.pos.product.Product;

import static ua.rud.pos.coin.Coins.*;

public class Runner {
    public static void main(String[] args) {
        Pos pos = new Pos();

        //Choose coffee and juice
        pos.addProduct("Coffee");
        pos.addProduct("Juice");

        //Insert 50 and two 25 coins
        pos.insertCoin(FIFTY);
        pos.insertCoin(TWENTY_FIVE);
        pos.insertCoin(TWENTY_FIVE);

        //Print total value of insered coins
        System.out.println("Total value of coins: " + pos.valueOfCoins());
        System.out.println();

        //Pay for products
        pos.pay();

        //Print change
        System.out.println("Change:");
        for (Coin coin : pos.returnCoins()) {
            System.out.println(coin);
        }
        System.out.println();

        //Print purchased products
        System.out.println("Purchased products: ");
        for (Product product : pos.getProducts()) {
            System.out.println(product);
        }
        System.out.println();

        //No change left
        System.out.println("Remaining change: " + pos.returnCoins().size());

        //No purchased products left
        System.out.println("Remaining purchased products: " + pos.getProducts().size());
    }
}
