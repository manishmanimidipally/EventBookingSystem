package main.com.eventbooking.dao;

import main.com.eventbooking.model.Event;
import java.util.List;

public interface EventDAO {

    boolean addEvent(Event event);

    Event getEventById(int eventId);

    List<Event> getAllEvents();

    List<Event> getEventsByType(String eventType);

    List<Event> getUpcomingEvents();

    boolean updateEvent(Event event);

    boolean deleteEvent(int eventId);
}