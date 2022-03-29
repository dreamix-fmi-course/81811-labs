package uni.fmi.week4.task2.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.week4.task2.exceptions.InvalidTicketException;
import uni.fmi.week4.task2.model.Event;
import uni.fmi.week4.task2.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private final Map<Long, Ticket> ticketDb = new ConcurrentHashMap<>();
    private final Map<Event, Set<Integer>> reservedSeats = new ConcurrentHashMap<>();
    private final Map<Event, Set<Integer>> reservedRows = new ConcurrentHashMap<>();

    @Override
    public void createTicket(Ticket ticket) throws InvalidTicketException {
        if (ticket == null) {
            throw new IllegalArgumentException("ticket cannot be null");
        }

        if (!ticketDb.containsKey(ticket.getTicketId())) {
            if (!isValidTicket(ticket)) {
                throw new InvalidTicketException("This ticket is invalid");
            }

            ticketDb.put(ticket.getTicketId(), ticket);
            reserveSeatingPlace(ticket.getEvent(), ticket.getRow(), ticket.getSeat());
        }
    }

    @Override
    public void removeTicket(Long id) {
        Ticket ticket = findById(id);
        if (ticket != null) {
            ticketDb.remove(id, ticket);
            freeSeatingPlace(ticket.getEvent(), ticket.getRow(), ticket.getSeat());
        }
    }

    @Override
    public Ticket findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return ticketDb.get(id);
    }

    @Override
    public void updateTicket(Ticket ticket) throws InvalidTicketException {
        if (ticket == null) {
            throw new IllegalArgumentException("ticket cannot be null");
        }

        Long id = ticket.getTicketId();
        Ticket ticketById = findById(id);
        if (ticketById != null) {
            if (!isValidTicket(ticket)) {
                throw new InvalidTicketException("This ticket is invalid");
            }

            ticketDb.put(id,
                new Ticket(id, ticket.getPrice(), ticket.getRow(),
                    ticket.getSeat(), ticket.getUser(), ticket.getEvent()));
            reserveSeatingPlace(ticket.getEvent(), ticket.getRow(), ticket.getSeat());
        }
    }

    @Override
    public Collection<Ticket> getAllTickets() {
        return ticketDb.values();
    }

    private boolean isValidTicket(Ticket ticket) {
        return ticket.getEvent().getDate().isAfter(LocalDateTime.now()) &&
               isFreePlace(ticket.getEvent(), ticket.getRow(), ticket.getSeat()) &&
               ticket.getPrice().compareTo(new BigDecimal(0)) >= 0;
    }

    private boolean isFreePlace(Event event, int row, int seat) {
        Set<Integer> seats = reservedSeats.get(event);
        Set<Integer> rows = reservedRows.get(event);
        if (seats == null || rows == null) {
            return true;
        }

        return !(seats.contains(seat) && rows.contains(row));
    }

    private void reserveSeatingPlace(Event event, int row, int seat) {
        if (!reservedRows.containsKey(event)) {
            reservedRows.put(event, new HashSet<>());
        }

        if (!reservedSeats.containsKey(event)) {
            reservedSeats.put(event, new HashSet<>());
        }

        reservedRows.get(event).add(row);
        reservedSeats.get(event).add(seat);
    }

    private void freeSeatingPlace(Event event, int row, int seat) {
        reservedRows.get(event).remove(row);
        reservedRows.get(event).remove(seat);
    }
}
