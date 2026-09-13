package main.com.eventbooking.model;

import java.time.LocalDateTime;

public class Booking {

    private int bookingId;
    private int userId;
    private int eventId;
    private int seatId;
    private LocalDateTime bookingDate;
    private double totalAmount;
    private String bookingStatus;

    public Booking() {
    }

    public Booking(int bookingId, int userId, int eventId,
                   int seatId, LocalDateTime bookingDate,
                   double totalAmount, String bookingStatus) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.eventId = eventId;
        this.seatId = seatId;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }

    public Booking(int userId, int eventId, int seatId,
                   LocalDateTime bookingDate,
                   double totalAmount, String bookingStatus) {

        this.userId = userId;
        this.eventId = eventId;
        this.seatId = seatId;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", seatId=" + seatId +
                ", bookingDate=" + bookingDate +
                ", totalAmount=" + totalAmount +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }
}