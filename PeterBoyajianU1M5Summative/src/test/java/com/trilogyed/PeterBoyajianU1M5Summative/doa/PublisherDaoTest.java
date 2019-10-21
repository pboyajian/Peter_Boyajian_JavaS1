package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Publisher;
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
public class PublisherDaoTest {

    @Autowired
    private PublisherDao publisherDao;
    private List<Publisher> publishers;
    private Publisher publisher;
    @Before
    public void setUp() throws Exception {
//
//        books=bookDao.getAllBooks();
//        books.forEach(a->bookDao.deleteBook(a.getBook_id()));

        List<Publisher> publishers=publisherDao.getAllPublishers();
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

        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);
        publisher.setPublisher_id(publisherAfterAdding.getPublisher_id());
        assertEquals(publisher,publisherAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);
        assertEquals(1,publisherDao.getAllPublishers().size());
        publisherDao.deletePublisher(publisherAfterAdding.getPublisher_id());
        assertEquals(0,publisherDao.getAllPublishers().size());
    }

    @Test
    public void shouldGetAll(){
        publisherDao.addPublisher(publisher);
        publisherDao.addPublisher(publisher);
        assertEquals(2,publisherDao.getAllPublishers().size());
    }

    @Test
    public void shouldGetOneById(){
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);
        int id=publisherAfterAdding.getPublisher_id();
        publisher.setPublisher_id(id);
        assertEquals(publisher, publisherDao.getPublisher(id));
    }

    @Test
    public void shouldUpdatePublisher(){
        Publisher publisherAfterAdding=publisherDao.addPublisher(publisher);
        int id=publisherAfterAdding.getPublisher_id();
        publisher.setPublisher_id(id);
        publisher.setName("updated_name");
        publisherDao.updatePublisher(publisher);
        assertEquals(publisher, publisherDao.getPublisher(id));
    }

}