package uni.fmi.week4.task2.repository;

import uni.fmi.week4.task2.model.Event;

public interface EventRepository {
    /***
     * Create event
     * @param event
     */
    void createEvent(Event event);

    /**
     * Remove event
     * @param id
     */
    void removeEvent(Long id);

    /**
     * Find event by id
     * @param id of the event
     * @return
     */
    Event findById(Long id);


    /**
     * Update event information
     * @param event
     */
    void updateEvent(Event event);
}
