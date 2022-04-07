package uni.fmi.week4.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.week4.task2.exceptions.InvalidTicketException;
import uni.fmi.week4.task2.model.Event;
import uni.fmi.week4.task2.model.Ticket;
import uni.fmi.week4.task2.model.User;
import uni.fmi.week4.task2.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void createTicket(Ticket ticket) throws InvalidTicketException {
        ticketRepository.createTicket(ticket);
    }

    @Override
    public void removeTicket(Long id) {
        ticketRepository.removeTicket(id);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) throws InvalidTicketException {
        ticketRepository.updateTicket(ticket);
    }

    @Override
    public List<Ticket> findAllTicketsByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return ticketRepository.getAllTickets().stream()
            .filter(t -> t.getUser().equals(user))
            .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("event cannot be null");
        }

        return ticketRepository.getAllTickets().stream()
            .filter(t -> t.getEvent().equals(event))
            .collect(Collectors.toList());
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDateTime from, LocalDateTime to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("parameters cannot be null");
        }

        return ticketRepository.getAllTickets().stream()
            .map(Ticket::getEvent)
            .filter(event -> event.getDate().isAfter(from))
            .filter(event -> event.getDate().isBefore(to))
            .collect(Collectors.toList());
    }
}
