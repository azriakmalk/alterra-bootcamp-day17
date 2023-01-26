package com.javatechie.redis.respository;

import com.javatechie.redis.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BookDao {
    public static final String HASH_KEY = "Book";
    @Autowired
    private RedisTemplate template;

    public Book save(Book book) {
//        long count = template.opsForHash().size(HASH_KEY);
//        count++;
//        book.setId((int) count);
        template.opsForHash().put(HASH_KEY, book.getId(), book );
        return book;
    }

    public Book update(int id, Book book) {
        template.opsForHash().put(HASH_KEY, id, book);
        return book;
    }
    public List<Book> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }
    public Book findBookById(int id) {
        return (Book) template.opsForHash().get(HASH_KEY, id);
    }
    public String deleteBook(int id) {
        template.opsForHash().delete(HASH_KEY,id);
        return "Book deleted";
    }
}
