package com.trilogyed.PeterBoyajianU1M5Summative.dao;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;
import com.trilogyed.PeterBoyajianU1M5Summative.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;
    private List<Book> books;
    private Author author;

    @Before
    public void setUp() throws Exception {
//
//        books=bookDao.getAllBooks();
//        books.forEach(a->bookDao.deleteBook(a.getBook_id()));

        List<Author> authors=authorDao.getAllAuthors();
        authors.forEach(a->authorDao.deleteAuthor(a.getAuthor_id()));

        author=new Author();
        author.setCity("city");
        author.setEmail("email");
        author.setFirst_name("first");
        author.setLast_name("last");
        author.setPhone("phone");
        author.setPostal_code("postal code");
        author.setState("IL");
        author.setStreet("street");
    }
    @Test
    public void shouldBeInDatabaseAfterWeAdd(){

        Author authorAfterAdding=authorDao.addAuthor(author);
        author.setAuthor_id(authorAfterAdding.getAuthor_id());
        assertEquals(author,authorAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        assertEquals(1,authorDao.getAllAuthors().size());
        authorDao.deleteAuthor(authorAfterAdding.getAuthor_id());
        assertEquals(0,authorDao.getAllAuthors().size());
    }

    @Test
    public void shouldGetAll(){
        authorDao.addAuthor(author);
        authorDao.addAuthor(author);
        assertEquals(2,authorDao.getAllAuthors().size());
    }

    @Test
    public void shouldGetOneById(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        int id=authorAfterAdding.getAuthor_id();
        author.setAuthor_id(id);
        assertEquals(author, authorDao.getAuthor(id));
    }

    @Test
    public void shouldUpdateAuthor(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        int id=authorAfterAdding.getAuthor_id();
        author.setAuthor_id(id);
        author.setFirst_name("updated_name");
        authorDao.updateAuthor(author);
        assertEquals(author, authorDao.getAuthor(id));
    }

}