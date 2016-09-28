package ua.rud.pos;

import ua.rud.pos.product.Product;

import java.util.*;

final class Sale {
    private List<Product> products = new ArrayList<>();
    private boolean paid = false;

    long total() {
        long sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void pay() {
        paid = true;
    }

    boolean isPaid() {
        return paid;
    }

    void clear() {
        products.clear();
    }

    List<Product> getProducts() {
        if (paid) {
            List<Product> productsToReturn = products;
            products = new ArrayList<>();
            return productsToReturn;
        } else {
            return new ArrayList<>();
        }
    }
}
