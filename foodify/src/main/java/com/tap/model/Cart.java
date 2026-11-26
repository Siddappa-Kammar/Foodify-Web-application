package com.tap.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private int restId;
    private Map<Integer, CartItem> items;

    public Cart() {
        super();
        items = new LinkedHashMap<>();
    }

    public Cart(int restId) {
        super();
        this.restId = restId;
        this.items = new LinkedHashMap<>();
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}