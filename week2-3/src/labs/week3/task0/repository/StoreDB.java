package labs.week3.task0.repository;

import labs.week3.task0.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StoreDB implements CRUD {
    private final Map<String, Book> db = new ConcurrentHashMap<>();

    @Override
    public void add(Book book) {
        db.put(book.getIsbn(), book);
    }

    @Override
    public Book update(Book book) {
        Book bookFromDB = getByKey(book.getIsbn());
        if (!book.equals(bookFromDB)) {
            db.put(book.getIsbn(), book);
        }

        return book;
    }

    @Override
    public void remove(String isbn) {
        db.remove(isbn);
    }

    @Override
    public void clear() {
        db.clear();
    }

    @Override
    public Book getByKey(String isbn) {
        return db.get(isbn);
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(db.values());
    }
}
