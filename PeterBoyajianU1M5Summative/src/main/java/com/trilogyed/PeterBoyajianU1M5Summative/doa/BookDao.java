package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;
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
