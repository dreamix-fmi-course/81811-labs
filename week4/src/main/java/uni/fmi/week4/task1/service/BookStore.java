package uni.fmi.week4.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.week4.task1.model.Book;
import uni.fmi.week4.task1.repository.CRUD;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookStore implements Store {
    //private CRUD dbCrud = new StoreDB();
    @Autowired
    private CRUD dbCrud;

    @Override
    public boolean add(Book o) {
        // o -> null
        Book byKey = dbCrud.getByKey(o.getISBN());
        /*if (byKey == null) {
            System.out.println("here");
            return false;
        }*/

        dbCrud.add(o);
        return true;

        /*if( byKey.equals(o)) {
            return  false;
        }
        // generate isbn
        System.out.println("here");
        dbCrud.add(o);
        return true;*/
    }

    @Override
    public void remove(Book o) {
        dbCrud.remove(o.getISBN());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {

        return dbCrud.getAll().stream()
            .filter(b -> b.getAuthor().equals(author))
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return dbCrud.getAll().stream()
            .filter(b -> b.getPublishedYear().isAfter(from))
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        // 3 < n < 7
        return dbCrud.getAll().stream() // 1, 2 ,3 ,4 ,5 ,6 ,7
            .filter(b -> b.getPublishedYear().isAfter(from)) // n > 3  // 4 5 6
            .filter(b -> b.getPublishedYear().isBefore(to)) // n < 7
            .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return dbCrud.getAll().stream().filter(bookPredicate).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        // version 1
//    List<Book> all = dbCrud.getAll();
//    List<String> ISBNs = all.stream().map(b -> b.getISBN()).collect(Collectors.toList());
//    ISBNs.forEach( isbn -> dbCrud.remove(isbn));
        //version 2
//    dbCrud.getAll().forEach(b -> dbCrud.remove(b.getISBN()));
        //version 3
        dbCrud.clear();
    }
}
