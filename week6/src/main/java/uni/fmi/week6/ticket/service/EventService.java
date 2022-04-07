package uni.fmi.week6.ticket.service;

import uni.fmi.week6.ticket.model.Event;

public interface EventService {
    void createEvent(Event event);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);
}
