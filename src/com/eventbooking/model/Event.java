package com.eventbooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private int eventId;
    private String eventName;
    private String eventType;
    private String venue;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private double ticketPrice;
    private int totalSeats;

    public Event() {
    }

    public Event(int eventId, String eventName, String eventType,
                 String venue, LocalDate eventDate,
                 LocalTime eventTime, double ticketPrice,
                 int totalSeats) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.venue = venue;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
    }

    public Event(String eventName, String eventType,
                 String venue, LocalDate eventDate,
                 LocalTime eventTime, double ticketPrice,
                 int totalSeats) {

        this.eventName = eventName;
        this.eventType = eventType;
        this.venue = venue;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", venue='" + venue + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", ticketPrice=" + ticketPrice +
                ", totalSeats=" + totalSeats +
                '}';
    }
}