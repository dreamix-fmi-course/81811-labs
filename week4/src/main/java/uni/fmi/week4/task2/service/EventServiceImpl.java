package uni.fmi.week4.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.week4.task2.model.Event;
import uni.fmi.week4.task2.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.createEvent(event);
    }

    @Override
    public void removeEvent(Long id) {
        eventRepository.removeEvent(id);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.updateEvent(event);
    }
}
