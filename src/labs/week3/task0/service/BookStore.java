package labs.week3.task0.service;

import labs.week3.task0.model.Book;
import labs.week3.task0.repository.CRUD;
import labs.week3.task0.repository.StoreDB;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {
    private final CRUD crudDB = new StoreDB();

    @Override
    public boolean add(Book o) {
        Book bookByKey = crudDB.getByKey(o.getIsbn());
        if (bookByKey.equals(o)) {
            return false;
        }

        crudDB.add(o);
        return true;
    }

    @Override
    public void remove(Book o) {
        crudDB.remove(o.getIsbn());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return crudDB.getAll().stream()
            .filter(b -> b.getAuthor().equals(author))
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return crudDB.getAll().stream()
            .filter(b -> b.getPublishedYear().isAfter(from))
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return crudDB.getAll().stream()
            .filter(b -> b.getPublishedYear().isAfter(from) && b.getPublishedYear().isBefore(to))
            .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        /*List<Book> allBooks = crudDB.getAll();
        allBooks.forEach(b -> crudDB.remove(b.getIsbn()));*/
        crudDB.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return crudDB.getAll().stream()
            .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return crudDB.getAll().stream()
            .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return crudDB.getAll().stream()
            .filter(bookPredicate)
            .collect(Collectors.toList());
    }
}
