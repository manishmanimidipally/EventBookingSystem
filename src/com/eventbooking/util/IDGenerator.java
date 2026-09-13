package com.eventbooking.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {

    private static final AtomicInteger USER_ID =
            new AtomicInteger(1001);

    private static final AtomicInteger ADMIN_ID =
            new AtomicInteger(5002);

    private static final AtomicInteger EVENT_ID =
            new AtomicInteger(10004);

    private static final AtomicInteger SEAT_ID =
            new AtomicInteger(20207);

    private static final AtomicInteger BOOKING_ID =
            new AtomicInteger(30001);

    private static final AtomicInteger PAYMENT_ID =
            new AtomicInteger(40001);

    private IDGenerator() {
        // Prevent object creation
    }

    public static int generateUserId() {
        return USER_ID.getAndIncrement();
    }

    public static int generateAdminId() {
        return ADMIN_ID.getAndIncrement();
    }

    public static int generateEventId() {
        return EVENT_ID.getAndIncrement();
    }

    public static int generateSeatId() {
        return SEAT_ID.getAndIncrement();
    }

    public static int generateBookingId() {
        return BOOKING_ID.getAndIncrement();
    }

    public static int generatePaymentId() {
        return PAYMENT_ID.getAndIncrement();
    }
}