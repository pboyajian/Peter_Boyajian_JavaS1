package com.trilogyed.PeterBoyajianU1M5Summative.dao;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {
    Book getBook(int id );
    List<Book> getAllBooks();
    void deleteBook(int id);
    void updateBook(Book book);
    Book addBook(Book book);
    List<Book> getBookByAuthor(int author_id);
}
