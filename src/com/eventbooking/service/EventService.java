package com.eventbooking.service;

import com.eventbooking.dao.EventDAO;
import com.eventbooking.dao.SeatDAO;
import com.eventbooking.daoimpl.EventDAOImpl;
import com.eventbooking.daoimpl.SeatDAOImpl;
import com.eventbooking.exception.EventNotFoundException;
import com.eventbooking.model.Event;
import com.eventbooking.model.Seat;
import com.eventbooking.util.IDGenerator;

import java.util.List;

public class EventService {

    private final EventDAO eventDAO;
    private final SeatDAO seatDAO;

    public EventService() {
        this.eventDAO = new EventDAOImpl();
        this.seatDAO = new SeatDAOImpl();
    }

    public boolean addEvent(Event event) {

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        if (event.getEventName() == null ||
                event.getEventName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Event name cannot be empty"
            );
        }

        if (event.getEventType() == null ||
                event.getEventType().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Event type cannot be empty"
            );
        }

        if (event.getVenue() == null ||
                event.getVenue().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Venue cannot be empty"
            );
        }

        if (event.getEventDate() == null) {
            throw new IllegalArgumentException(
                    "Event date cannot be null"
            );
        }

        if (event.getEventTime() == null) {
            throw new IllegalArgumentException(
                    "Event time cannot be null"
            );
        }

        if (event.getTicketPrice() <= 0) {
            throw new IllegalArgumentException(
                    "Ticket price must be greater than zero"
            );
        }

        if (event.getTotalSeats() <= 0) {
            throw new IllegalArgumentException(
                    "Total seats must be greater than zero"
            );
        }

        event.setEventId(IDGenerator.generateEventId());

        return eventDAO.addEvent(event);
    }

    public Event getEventById(int eventId) {

        Event event = eventDAO.getEventById(eventId);

        if (event == null) {
            throw new EventNotFoundException(
                    "Event not found with ID: " + eventId
            );
        }

        return event;
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    public List<Event> getEventsByType(String eventType) {

        if (eventType == null || eventType.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Event type cannot be empty"
            );
        }

        return eventDAO.getEventsByType(eventType);
    }

    public List<Event> getUpcomingEvents() {
        return eventDAO.getUpcomingEvents();
    }

    public boolean updateEvent(Event event) {

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        getEventById(event.getEventId());

        return eventDAO.updateEvent(event);
    }

    public boolean deleteEvent(int eventId) {

        getEventById(eventId);

        return eventDAO.deleteEvent(eventId);
    }

    public List<Seat> getAvailableSeats(int eventId) {

        getEventById(eventId);

        return seatDAO.getAvailableSeats(eventId);
    }
}