package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;
import com.trilogyed.PeterBoyajianU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {
    private BookDao bookDao;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private static final String SELECT_ALL_BOOKS_SQL= "select * from book";
    private static final String SELECT_BOOK_SQL= "select * from book where book_id = ?";
    private static final String SELECT_BOOK_BY_AUTHOR_SQL= "select * from book where author_id = ?";
    private static final String UPDATE_BOOK_SQL= "update book set isbn=?,publish_date=?,author_id=?,title=?,publisher_id=?,price=? where book_id = ?";
    private static final String DELETE_BOOK_SQL= "delete from book where book_id = ?";
    private static final String INSERT_BOOK_SQL= "insert into book ( isbn, publish_date, author_id, title,publisher_id,price) values (?,?,?,?,?,?); ";

    private Book mapRowToBook (ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(Integer.parseInt(rs.getString("book_id")));
        book.setIsbn(rs.getString("isbn"));
        book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
        book.setAuthor_id(Integer.parseInt(rs.getString("author_id")));
        book.setTitle(rs.getString("title"));
        book.setPublisher_id(Integer.parseInt(rs.getString("publisher_id")));
        book.setPrice(Double.parseDouble(rs.getString("price")));
        return book;
    }
    @Override
    public Book getBook(int id) {
        try{ return jdbcTemplate.queryForObject(SELECT_BOOK_SQL,this::mapRowToBook,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }
    }

    @Override
    public List<Book> getAllBooks() {

        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL,this::mapRowToBook);
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL,
                id);
    }

    @Override
    public void updateBook(Book book) {

        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),book.getPublisher_id(),
                book.getPrice(),
                book.getBook_id());
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),book.getPublisher_id(),
                book.getPrice());
        int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        book.setBook_id(id);
        return book;
    }

    @Override
    public List<Book> getBookByAuthor(int author_id) {
        try{ return jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR_SQL,this::mapRowToBook,author_id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }

    }
}
