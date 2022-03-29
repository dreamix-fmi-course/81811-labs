package uni.fmi.week4.task1.repository;

import uni.fmi.week4.task1.model.Book;

import java.util.List;

public interface CRUD {
    void add(Book book);

    Book update(Book book);

    void remove(String isbn);

    Book getByKey(String isbn);

    List<Book> getAll();

    void clear();
}
