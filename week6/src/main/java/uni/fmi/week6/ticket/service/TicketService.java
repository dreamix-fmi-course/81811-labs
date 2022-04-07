package uni.fmi.week6.ticket.service;

import uni.fmi.week6.ticket.exceptions.InvalidTicketException;
import uni.fmi.week6.ticket.model.Event;
import uni.fmi.week6.ticket.model.Ticket;
import uni.fmi.week6.ticket.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    /**
     * Create and validate ticket.
     * Can NOT create ticket in the past.
     * Can NOT create ticket with negative price.
     * Can NOT duplicate row and seat same event.
     *
     * @param ticket
     */
    void createTicket(Ticket ticket) throws InvalidTicketException;

    void removeTicket(Long id);

    Ticket findById(Long id);

    void updateTicket(Ticket ticket) throws InvalidTicketException;

    /**
     * Return all tickets bought by a user
     *
     * @param user
     * @return
     */
    List<Ticket> findAllTicketsByUser(User user);

    /**
     * Return all sold tickets by event
     *
     * @param event
     * @return
     */
    List<Ticket> findAllTicketByEvent(Event event);

    /**
     * Return all available events for between two dates
     *
     * @param from
     * @param to
     * @return
     */
    List<Event> findAllEventsBetweenDates(LocalDateTime from, LocalDateTime to);
}
