package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;
import com.trilogyed.PeterBoyajianU1M5Summative.model.Book;
import com.trilogyed.PeterBoyajianU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {
   @Autowired
   private BookDao bookDao;
   @Autowired
   private AuthorDao authorDao;
   @Autowired
   private PublisherDao publisherDao;
   private List<Book> books;
   private List<Author> authors;
   private List<Publisher> publishers;
   private Author author;
   private Publisher publisher;
   private Book book;

    @Before
    public void setUp() throws Exception {
        books=bookDao.getAllBooks();
        books.forEach(a->bookDao.deleteBook(a.getBook_id()));

        book=new Book();
        book.setIsbn("ISBN");
        book.setPublish_date(new Date());
        book.setTitle("title");
        book.setPrice(3.14);

        authors=authorDao.getAllAuthors();
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

        publishers=publisherDao.getAllPublishers();
        publishers.forEach(a->publisherDao.deletePublisher(a.getPublisher_id()));

        publisher=new Publisher();
        publisher.setCity("city");
        publisher.setEmail("email");
        publisher.setName("name");
        publisher.setPhone("phone");
        publisher.setPostal_code("postal code");
        publisher.setState("IL");
        publisher.setStreet("street");
    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);

        Book bookAfterAdding=bookDao.addBook(book);
        book.setBook_id(bookAfterAdding.getBook_id());
        assertEquals(book,bookAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);

        Book bookAfterAdding=bookDao.addBook(book);
        assertEquals(1,bookDao.getAllBooks().size());
        bookDao.deleteBook(bookAfterAdding.getBook_id());
        assertEquals(0,bookDao.getAllBooks().size());
    }

    @Test
    public void shouldGetAll(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);
        bookDao.addBook(book);
        bookDao.addBook(book);
        assertEquals(2,bookDao.getAllBooks().size());
    }

    @Test
    public void shouldGetOneById(){

        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);

        Book bookAfterAdding=bookDao.addBook(book);
        int id=bookAfterAdding.getBook_id();
        book.setBook_id(id);
        assertEquals(book, bookDao.getBook(id));
    }

    @Test
    public void shouldUpdateBook(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);
        Book bookAfterAdding=bookDao.addBook(book);
        int id=bookAfterAdding.getBook_id();
        book.setBook_id(id);
        book.setIsbn("new isbn");
        bookDao.updateBook(book);
        assertEquals(book, bookDao.getBook(id));
    }

    @Test
    public void shouldGetBookByAuthor(){
        Author authorAfterAdding=authorDao.addAuthor(author);
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);

        int author_id=authorAfterAdding.getAuthor_id();
        int publisher_id=publisherAfterAdding.getPublisher_id();

        book.setAuthor_id(author_id);
        book.setPublisher_id(publisher_id);

        Book bookAfterAdding=bookDao.addBook(book);
        int id=bookAfterAdding.getBook_id();
        book.setBook_id(id);
        assertEquals(book, bookDao.getBookByAuthor(author_id).get(0));
    }

}