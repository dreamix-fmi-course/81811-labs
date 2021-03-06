package uni.fmi.week4.task2.service;

import uni.fmi.week4.task2.model.Event;

public interface EventService {
    void createEvent(Event event);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);
}
