package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {
    Author getAuthor(int id );
    List<Author> getAllAuthors();
    void deleteAuthor(int id);
    void updateAuthor(Author author);
    Author addAuthor(Author author);
}
