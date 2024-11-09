package com.example.food_ordering_app.adapters;

import com.example.food_ordering_app.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartSingleton {
    private static CartSingleton instance;
    private List<CartModel> cartItems;

    private CartSingleton() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartSingleton getInstance() {
        if (instance == null) {
            instance = new CartSingleton();
        }
        return instance;
    }

    public List<CartModel> getCartItems() {
        return cartItems;
    }

    public void addItem(CartModel item) {
        cartItems.add(item);
    }
}
