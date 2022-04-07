package uni.fmi.week6.task2.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.week6.task2.model.Event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private Map<Long, Event> eventDb = new ConcurrentHashMap<>();

    @Override
    public void createEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("event cannot be null");
        }

        eventDb.putIfAbsent(event.getEventId(), event);
    }

    @Override
    public void removeEvent(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        Event event = findById(id);
        if (event != null) {
            eventDb.remove(id, event);
        }
    }

    @Override
    public Event findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        return eventDb.get(id);
    }

    @Override
    public void updateEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("event cannot be null");
        }

        Long id = event.getEventId();
        Event eventById = findById(id);
        if (eventById != null) {
            eventDb.put(id, new Event(id, event.getName(), event.getDate(), event.getDescription()));
        }
    }
}
