package labs.week3.task0;

import labs.week3.task0.model.Book;
import labs.week3.task0.service.BookStore;
import labs.week3.task0.service.Store;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BookStoreProgram {
    public static void main(String[] args) {
        Store store = new BookStore();
        store.add(new Book("title",
            "author",
            new BigDecimal(20),
            "publisher", LocalDate.of(2000, 12, 12)));

        List<Book> books = store.getAllBooksPublishedAfter(LocalDate.of(2000, 1, 1));
        books.forEach(System.out::println);
    }
}
