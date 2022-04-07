package labs.week3.task0.repository;

import labs.week3.task0.model.Book;

import java.util.List;

public interface CRUD {
    void add(Book book);

    Book update(Book book);

    void remove(String isbn);

    void clear();

    Book getByKey(String isbn);

    List<Book> getAll();
}
