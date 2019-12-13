package com.example.clientservice.model;

import java.util.Objects;

public class Account {
    private Integer id;
    private double balanceAmount;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balanceAmount=" + balanceAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balanceAmount, balanceAmount) == 0 &&
                Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balanceAmount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
