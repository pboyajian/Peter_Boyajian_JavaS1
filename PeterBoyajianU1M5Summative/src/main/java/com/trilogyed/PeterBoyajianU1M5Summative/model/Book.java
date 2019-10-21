package com.trilogyed.PeterBoyajianU1M5Summative.model;

import java.time.LocalDate;
//import java.util.Date;
import java.util.Objects;

public class Book {
    private int book_id;
    private String isbn;
    private LocalDate publish_date;
    private int author_id;
    private String title;
    private int publisher_id;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", isbn='" + isbn + '\'' +
                ", publish_date=" + publish_date +
                ", author_id=" + author_id +
                ", title='" + title + '\'' +
                ", publisher_id=" + publisher_id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id &&
                author_id == book.author_id &&
                publisher_id == book.publisher_id &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(publish_date, book.publish_date) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, isbn, publish_date, author_id, title, publisher_id, price);
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(int book_id, String isbn, LocalDate publish_date, int author_id, String title, int publisher_id, double price) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.publish_date = publish_date;
        this.author_id = author_id;
        this.title = title;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public Book() {
    }
}
