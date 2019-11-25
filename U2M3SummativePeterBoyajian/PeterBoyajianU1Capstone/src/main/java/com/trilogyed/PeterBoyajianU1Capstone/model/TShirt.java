package com.trilogyed.PeterBoyajianU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class TShirt extends Item {
    @NotEmpty(message = "TShirt size cannot be empty.")
    private String size;
    @NotEmpty(message = "TShirt color cannot be empty.")
    private String color;
    @NotEmpty(message = "TShirt description cannot be empty.")
    private String description;

    public TShirt() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, description);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
