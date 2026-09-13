package main.com.eventbooking.dao;

import main.com.eventbooking.model.Seat;
import java.util.List;

public interface SeatDAO {

    boolean addSeat(Seat seat);

    Seat getSeatById(int seatId);

    List<Seat> getSeatsByEvent(int eventId);

    List<Seat> getAvailableSeats(int eventId);

    boolean updateSeatAvailability(int seatId, boolean available);

    boolean deleteSeat(int seatId);
}