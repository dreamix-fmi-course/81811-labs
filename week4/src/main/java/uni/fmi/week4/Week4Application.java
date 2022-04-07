package uni.fmi.week4;

import uni.fmi.week4.task2.exceptions.InvalidTicketException;
import uni.fmi.week4.task2.logger.Logger;
import uni.fmi.week4.task2.model.Event;
import uni.fmi.week4.task2.model.Ticket;
import uni.fmi.week4.task2.model.User;
import uni.fmi.week4.task2.service.EventService;
import uni.fmi.week4.task2.service.TicketService;
import uni.fmi.week4.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uni.fmi.week4.task1.model.Book;
import uni.fmi.week4.task1.service.BookStore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Week4Application implements CommandLineRunner {

    @Autowired
    private BookStore store;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private Logger logger;

    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }

    public void bookDemo() {
        System.out.println(">>>> PRINT");
        Book book = new Book();
        book.setPublishedYear(LocalDate.of(2001, 12, 12));
        book.setISBN("isbn");
        store.add(book);
        List<Book> result = store.getAllBooksBetween(LocalDate.of(2000, 1, 1), LocalDate.now());
        result.forEach(System.out::println);
    }

    public void ticketDemo() throws InvalidTicketException {

        User user1 = new User(1L, "misho", "misho@abv.bg");
        User user2 = new User(2L, "pesho", "pesho@gmail.com");
        User user3 = new User(3L, "mimi", "mimi@abv.bg");

        userService.createUser(new User(1L, "misho", "misho@abv.bg"));
        userService.createUser(new User(2L, "pesho", "pesho@gmail.com"));
        userService.createUser(new User(3L, "mimi", "mimi@abv.bg"));

        System.out.println(userService.findById(1L));

        Event event1 = new Event(1L, "event1", LocalDateTime.now().plusDays(1), "description1");
        Event event2 = new Event(2L, "event2", LocalDateTime.now().plusDays(2), "description2");
        Event event3 = new Event(3L, "event3", LocalDateTime.now().plusDays(3), "description3");
        eventService.createEvent(event1);
        eventService.createEvent(event2);
        eventService.createEvent(event3);

        Ticket ticket1 = new Ticket(1L, new BigDecimal(20), 1, 1, user1, event1);
        Ticket ticket2 = new Ticket(2L, new BigDecimal(50), 1, 2, user2, event2);
        Ticket ticket3 = new Ticket(3L, new BigDecimal(100), 10, 1, user3, event3);
        ticketService.createTicket(ticket1);
        ticketService.createTicket(ticket2);
        ticketService.createTicket(ticket3);

        ticketService.findAllEventsBetweenDates(LocalDateTime.now().minusDays(100), LocalDateTime.now().plusDays(100))
            .forEach(System.out::println);

        System.out.println(ticketService.findById(3L));
        ticketService.updateTicket(new Ticket(3L, new BigDecimal(50), 10, 7, user3, event3));
        System.out.println(ticketService.findById(3L));

        ticketService.removeTicket(1L);
        System.out.println(ticketService.findById(1L)); //null

        ticketService.findAllTicketByEvent(event3).forEach(System.out::println);

        Ticket invalidTicket = new Ticket(4L, new BigDecimal(5), 10, 7, user3, event3);
        ticketService.createTicket(invalidTicket);
    }

    @Override
    public void run(String... args) {
        //bookDemo();

        try {
            ticketDemo();
        } catch (InvalidTicketException e) {
            System.err.println("Invalid ticket information");
        }

        logger.info("logging");
    }
}
