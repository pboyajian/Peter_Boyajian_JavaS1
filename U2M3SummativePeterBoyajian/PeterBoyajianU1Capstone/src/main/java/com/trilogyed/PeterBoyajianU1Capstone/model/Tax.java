package com.trilogyed.PeterBoyajianU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax {
    private String state;
    private BigDecimal rate;

    public Tax() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return state.equals(tax.state) &&
                rate.equals(tax.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
