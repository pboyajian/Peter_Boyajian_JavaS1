package com.trilogyed.U1M4SummativeBoyajianPeter.models;

import java.util.Objects;

public class Quote {
    private String author;
    private String quote;

    public Quote() {
    }

    public Quote(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(author, quote1.author) &&
                Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, quote);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "Author='" + author + '\'' +
                ", Quote='" + quote + '\'' +
                '}';
    }
}
