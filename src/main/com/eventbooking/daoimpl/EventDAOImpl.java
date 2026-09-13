package main.com.eventbooking.daoimpl;

import main.com.eventbooking.dao.EventDAO;
import main.com.eventbooking.model.Event;
import main.com.eventbooking.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public boolean addEvent(Event event) {

        String sql = "INSERT INTO events " +
                "(event_id, event_name, event_type, venue, " +
                "event_date, event_time, ticket_price, total_seats) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, event.getEventId());
            ps.setString(2, event.getEventName());
            ps.setString(3, event.getEventType());
            ps.setString(4, event.getVenue());
            ps.setDate(5, Date.valueOf(event.getEventDate()));
            ps.setTime(6, Time.valueOf(event.getEventTime()));
            ps.setDouble(7, event.getTicketPrice());
            ps.setInt(8, event.getTotalSeats());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Event getEventById(int eventId) {

        String sql = "SELECT * FROM events WHERE event_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eventId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return mapEvent(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Event> getAllEvents() {

        List<Event> events = new ArrayList<>();

        String sql = "SELECT * FROM events";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                events.add(mapEvent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public List<Event> getEventsByType(String eventType) {

        List<Event> events = new ArrayList<>();

        String sql = "SELECT * FROM events WHERE event_type = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, eventType);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    events.add(mapEvent(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public List<Event> getUpcomingEvents() {

        List<Event> events = new ArrayList<>();

        String sql = "SELECT * FROM events WHERE event_date >= CURRENT_DATE";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                events.add(mapEvent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public boolean updateEvent(Event event) {

        String sql = "UPDATE events SET event_name = ?, " +
                "event_type = ?, venue = ?, event_date = ?, " +
                "event_time = ?, ticket_price = ?, total_seats = ? " +
                "WHERE event_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, event.getEventName());
            ps.setString(2, event.getEventType());
            ps.setString(3, event.getVenue());
            ps.setDate(4, Date.valueOf(event.getEventDate()));
            ps.setTime(5, Time.valueOf(event.getEventTime()));
            ps.setDouble(6, event.getTicketPrice());
            ps.setInt(7, event.getTotalSeats());
            ps.setInt(8, event.getEventId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteEvent(int eventId) {

        String sql = "DELETE FROM events WHERE event_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, eventId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Event mapEvent(ResultSet rs) throws SQLException {

        Event event = new Event();

        event.setEventId(rs.getInt("event_id"));
        event.setEventName(rs.getString("event_name"));
        event.setEventType(rs.getString("event_type"));
        event.setVenue(rs.getString("venue"));

        Date date = rs.getDate("event_date");
        Time time = rs.getTime("event_time");

        if (date != null) {
            event.setEventDate(date.toLocalDate());
        }

        if (time != null) {
            event.setEventTime(time.toLocalTime());
        }

        event.setTicketPrice(rs.getDouble("ticket_price"));
        event.setTotalSeats(rs.getInt("total_seats"));

        return event;
    }
}