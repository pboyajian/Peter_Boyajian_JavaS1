package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher getPublisher(int id );
    List<Publisher> getAllPublishers();
    void deletePublisher(int id);
    void updatePublisher(Publisher publisher);
    Publisher addPublisher(Publisher publisher);
}
