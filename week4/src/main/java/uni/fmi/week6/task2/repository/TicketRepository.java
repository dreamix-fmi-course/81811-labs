package uni.fmi.week6.task2.repository;

import uni.fmi.week6.task2.exceptions.InvalidTicketException;
import uni.fmi.week6.task2.model.Ticket;

import java.util.Collection;

public interface TicketRepository {
    /**
     * Create ticket
     */
    void createTicket(Ticket ticket) throws InvalidTicketException;

    /**
     * Remove ticket
     */
    void removeTicket(Long id);

    /**
     * Find ticket by Id
     */
    Ticket findById(Long id);

    /**
     * Update ticket information
     */
    void updateTicket(Ticket ticket) throws InvalidTicketException;

    Collection<Ticket> getAllTickets();
}
