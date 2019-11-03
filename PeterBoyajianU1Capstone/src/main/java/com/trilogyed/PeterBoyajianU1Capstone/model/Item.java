package com.trilogyed.PeterBoyajianU1Capstone.model;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public abstract class Item {
    private int id;
    @Min(value = 0,message = "Price must be positive.")
    private BigDecimal price;
    @Min(value = 0,message = "Quantity must be positive.")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
