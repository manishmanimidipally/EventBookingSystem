package com.eventbooking.service;

import com.eventbooking.dao.BookingDAO;
import com.eventbooking.dao.EventDAO;
import com.eventbooking.dao.SeatDAO;
import com.eventbooking.daoimpl.BookingDAOImpl;
import com.eventbooking.daoimpl.EventDAOImpl;
import com.eventbooking.daoimpl.SeatDAOImpl;
import com.eventbooking.exception.BookingNotFoundException;
import com.eventbooking.exception.EventNotFoundException;
import com.eventbooking.exception.SeatNotAvailableException;
import com.eventbooking.model.Booking;
import com.eventbooking.model.Event;
import com.eventbooking.model.Seat;
import com.eventbooking.util.IDGenerator;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService {

    private final BookingDAO bookingDAO;
    private final EventDAO eventDAO;
    private final SeatDAO seatDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAOImpl();
        this.eventDAO = new EventDAOImpl();
        this.seatDAO = new SeatDAOImpl();
    }

    public boolean createBooking(int userId, int eventId, int seatId) {

        Event event = eventDAO.getEventById(eventId);

        if (event == null) {
            throw new EventNotFoundException(
                    "Event not found with ID: " + eventId
            );
        }

        Seat seat = seatDAO.getSeatById(seatId);

        if (seat == null) {
            throw new IllegalArgumentException(
                    "Seat not found with ID: " + seatId
            );
        }

        if (seat.getEventId() != eventId) {
            throw new IllegalArgumentException(
                    "Seat does not belong to this event"
            );
        }

        if (!seat.isAvailable()) {
            throw new SeatNotAvailableException(
                    "Seat " + seat.getSeatNumber() +
                    " is not available"
            );
        }

        Booking booking = new Booking();

        booking.setBookingId(IDGenerator.generateBookingId());
        booking.setUserId(userId);
        booking.setEventId(eventId);
        booking.setSeatId(seatId);
        booking.setBookingDate(LocalDateTime.now());
        booking.setTotalAmount(seat.getPrice());
        booking.setBookingStatus("CONFIRMED");

        boolean bookingCreated =
                bookingDAO.createBooking(booking);

        if (bookingCreated) {

            boolean seatUpdated =
                    seatDAO.updateSeatAvailability(
                            seatId,
                            false
                    );

            if (!seatUpdated) {
                throw new IllegalStateException(
                        "Booking created but seat status could not be updated"
                );
            }

            return true;
        }

        return false;
    }

    public Booking getBookingById(int bookingId) {

        Booking booking =
                bookingDAO.getBookingById(bookingId);

        if (booking == null) {
            throw new BookingNotFoundException(
                    "Booking not found with ID: " + bookingId
            );
        }

        return booking;
    }

    public List<Booking> getBookingsByUser(int userId) {
        return bookingDAO.getBookingsByUser(userId);
    }

    public List<Booking> getBookingsByEvent(int eventId) {

        Event event = eventDAO.getEventById(eventId);

        if (event == null) {
            throw new EventNotFoundException(
                    "Event not found with ID: " + eventId
            );
        }

        return bookingDAO.getBookingsByEvent(eventId);
    }

    public boolean cancelBooking(int bookingId) {

        Booking booking = getBookingById(bookingId);

        if ("CANCELLED".equalsIgnoreCase(
                booking.getBookingStatus())) {

            throw new IllegalStateException(
                    "Booking is already cancelled"
            );
        }

        boolean cancelled =
                bookingDAO.cancelBooking(bookingId);

        if (cancelled) {

            seatDAO.updateSeatAvailability(
                    booking.getSeatId(),
                    true
            );

            return true;
        }

        return false;
    }

    public boolean updateBookingStatus(
            int bookingId,
            String status) {

        getBookingById(bookingId);

        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Booking status cannot be empty"
            );
        }

        return bookingDAO.updateBookingStatus(
                bookingId,
                status
        );
    }
}