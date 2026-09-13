package com.eventbooking.dao;

import com.eventbooking.model.Booking;
import java.util.List;

public interface BookingDAO {

    boolean createBooking(Booking booking);

    Booking getBookingById(int bookingId);

    List<Booking> getBookingsByUser(int userId);

    List<Booking> getBookingsByEvent(int eventId);

    boolean updateBookingStatus(int bookingId, String status);

    boolean cancelBooking(int bookingId);

    boolean deleteBooking(int bookingId);
}