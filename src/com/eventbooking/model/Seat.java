package com.eventbooking.model;

public class Seat {

    private int seatId;
    private int eventId;
    private String seatNumber;
    private String seatType;
    private double price;
    private boolean available;

    public Seat() {
    }

    public Seat(int seatId, int eventId, String seatNumber,
                String seatType, double price, boolean available) {

        this.seatId = seatId;
        this.eventId = eventId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.available = available;
    }

    public Seat(int eventId, String seatNumber,
                String seatType, double price,
                boolean available) {

        this.eventId = eventId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.available = available;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", eventId=" + eventId +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}