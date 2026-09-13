-- ============================================================
-- EVENT TICKET BOOKING SYSTEM
-- DATABASE SCRIPT
-- ============================================================


-- ============================================================
-- 1. CREATE DATABASE
-- ============================================================

CREATE DATABASE IF NOT EXISTS event_booking;

USE event_booking;


-- ============================================================
-- 2. DROP EXISTING TABLES
--    Drop child tables first because of foreign keys
-- ============================================================

DROP TABLE IF EXISTS payments;

DROP TABLE IF EXISTS bookings;

DROP TABLE IF EXISTS seats;

DROP TABLE IF EXISTS events;

DROP TABLE IF EXISTS admins;

DROP TABLE IF EXISTS users;


-- ============================================================
-- 3. USERS TABLE
-- ============================================================

CREATE TABLE users
(
    user_id INT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(100) NOT NULL,

    phone VARCHAR(15) NOT NULL
);


-- ============================================================
-- 4. ADMINS TABLE
-- ============================================================

CREATE TABLE admins
(
    admin_id INT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(100) NOT NULL,

    phone VARCHAR(15) NOT NULL,

    admin_role VARCHAR(50) NOT NULL
);


-- ============================================================
-- 5. EVENTS TABLE
-- ============================================================

CREATE TABLE events
(
    event_id INT PRIMARY KEY,

    event_name VARCHAR(150) NOT NULL,

    event_type VARCHAR(50) NOT NULL,

    venue VARCHAR(200) NOT NULL,

    event_date DATE NOT NULL,

    event_time TIME NOT NULL,

    ticket_price DECIMAL(10,2) NOT NULL,

    total_seats INT NOT NULL
);


-- ============================================================
-- 6. SEATS TABLE
-- ============================================================

CREATE TABLE seats
(
    seat_id INT PRIMARY KEY,

    event_id INT NOT NULL,

    seat_number VARCHAR(20) NOT NULL,

    seat_type VARCHAR(50) NOT NULL,

    price DECIMAL(10,2) NOT NULL,

    available BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_seat_event
        FOREIGN KEY (event_id)
        REFERENCES events(event_id),

    CONSTRAINT unique_event_seat
        UNIQUE (event_id, seat_number)
);


-- ============================================================
-- 7. BOOKINGS TABLE
-- ============================================================

CREATE TABLE bookings
(
    booking_id INT PRIMARY KEY,

    user_id INT NOT NULL,

    event_id INT NOT NULL,

    seat_id INT NOT NULL,

    booking_date TIMESTAMP NOT NULL,

    total_amount DECIMAL(10,2) NOT NULL,

    booking_status VARCHAR(30) NOT NULL,

    CONSTRAINT fk_booking_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id),

    CONSTRAINT fk_booking_event
        FOREIGN KEY (event_id)
        REFERENCES events(event_id),

    CONSTRAINT fk_booking_seat
        FOREIGN KEY (seat_id)
        REFERENCES seats(seat_id)
);


-- ============================================================
-- 8. PAYMENTS TABLE
-- ============================================================

CREATE TABLE payments
(
    payment_id INT PRIMARY KEY,

    booking_id INT NOT NULL,

    amount DECIMAL(10,2) NOT NULL,

    payment_method VARCHAR(30) NOT NULL,

    payment_status VARCHAR(30) NOT NULL,

    payment_date TIMESTAMP NOT NULL,

    transaction_id VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT fk_payment_booking
        FOREIGN KEY (booking_id)
        REFERENCES bookings(booking_id)
);


-- ============================================================
-- 9. INSERT SAMPLE USERS
-- ============================================================

INSERT INTO users
(
    user_id,
    name,
    email,
    password,
    phone
)
VALUES
(
    1001,
    'Manish',
    'manish@gmail.com',
    'manish123',
    '9876543210'
),

(
    1002,
    'Rahul',
    'rahul@gmail.com',
    'rahul123',
    '9876543211'
),

(
    1003,
    'Priya',
    'priya@gmail.com',
    'priya123',
    '9876543212'
);


-- ============================================================
-- 10. INSERT SAMPLE ADMIN
-- ============================================================

INSERT INTO admins
(
    admin_id,
    name,
    email,
    password,
    phone,
    admin_role
)
VALUES
(
    5001,
    'Admin',
    'admin@gmail.com',
    'admin123',
    '9999999999',
    'EVENT_MANAGER'
);


-- ============================================================
-- 11. INSERT SAMPLE EVENTS
-- ============================================================

INSERT INTO events
(
    event_id,
    event_name,
    event_type,
    venue,
    event_date,
    event_time,
    ticket_price,
    total_seats
)
VALUES
(
    10001,
    'Arijit Singh Live Concert',
    'CONCERT',
    'Gachibowli Stadium',
    '2026-10-10',
    '19:00:00',
    1500.00,
    15
),

(
    10002,
    'India vs Australia',
    'SPORTS',
    'Rajiv Gandhi International Stadium',
    '2026-10-20',
    '18:30:00',
    2500.00,
    9
),

(
    10003,
    'Java Developer Conference',
    'CONFERENCE',
    'HICC Hyderabad',
    '2026-11-05',
    '09:30:00',
    1000.00,
    6
);


-- ============================================================
-- 12. INSERT SEATS FOR EVENT 10001
-- ============================================================

INSERT INTO seats
(
    seat_id,
    event_id,
    seat_number,
    seat_type,
    price,
    available
)
VALUES
(
    20001,
    10001,
    'A1',
    'VIP',
    2500.00,
    TRUE
),

(
    20002,
    10001,
    'A2',
    'VIP',
    2500.00,
    TRUE
),

(
    20003,
    10001,
    'A3',
    'VIP',
    2500.00,
    TRUE
),

(
    20004,
    10001,
    'A4',
    'VIP',
    2500.00,
    TRUE
),

(
    20005,
    10001,
    'A5',
    'VIP',
    2500.00,
    TRUE
),

(
    20006,
    10001,
    'B1',
    'PREMIUM',
    1800.00,
    TRUE
),

(
    20007,
    10001,
    'B2',
    'PREMIUM',
    1800.00,
    TRUE
),

(
    20008,
    10001,
    'B3',
    'PREMIUM',
    1800.00,
    TRUE
),

(
    20009,
    10001,
    'B4',
    'PREMIUM',
    1800.00,
    TRUE
),

(
    20010,
    10001,
    'B5',
    'PREMIUM',
    1800.00,
    TRUE
),

(
    20011,
    10001,
    'C1',
    'REGULAR',
    1500.00,
    TRUE
),

(
    20012,
    10001,
    'C2',
    'REGULAR',
    1500.00,
    TRUE
),

(
    20013,
    10001,
    'C3',
    'REGULAR',
    1500.00,
    TRUE
),

(
    20014,
    10001,
    'C4',
    'REGULAR',
    1500.00,
    TRUE
),

(
    20015,
    10001,
    'C5',
    'REGULAR',
    1500.00,
    TRUE
);


-- ============================================================
-- 13. INSERT SEATS FOR EVENT 10002
-- ============================================================

INSERT INTO seats
(
    seat_id,
    event_id,
    seat_number,
    seat_type,
    price,
    available
)
VALUES
(
    20101,
    10002,
    'A1',
    'VIP',
    5000.00,
    TRUE
),

(
    20102,
    10002,
    'A2',
    'VIP',
    5000.00,
    TRUE
),

(
    20103,
    10002,
    'A3',
    'VIP',
    5000.00,
    TRUE
),

(
    20104,
    10002,
    'B1',
    'PREMIUM',
    3500.00,
    TRUE
),

(
    20105,
    10002,
    'B2',
    'PREMIUM',
    3500.00,
    TRUE
),

(
    20106,
    10002,
    'B3',
    'PREMIUM',
    3500.00,
    TRUE
),

(
    20107,
    10002,
    'C1',
    'REGULAR',
    2500.00,
    TRUE
),

(
    20108,
    10002,
    'C2',
    'REGULAR',
    2500.00,
    TRUE
),

(
    20109,
    10002,
    'C3',
    'REGULAR',
    2500.00,
    TRUE
);


-- ============================================================
-- 14. INSERT SEATS FOR EVENT 10003
-- ============================================================

INSERT INTO seats
(
    seat_id,
    event_id,
    seat_number,
    seat_type,
    price,
    available
)
VALUES
(
    20201,
    10003,
    'A1',
    'VIP',
    2000.00,
    TRUE
),

(
    20202,
    10003,
    'A2',
    'VIP',
    2000.00,
    TRUE
),

(
    20203,
    10003,
    'A3',
    'VIP',
    2000.00,
    TRUE
),

(
    20204,
    10003,
    'B1',
    'REGULAR',
    1000.00,
    TRUE
),

(
    20205,
    10003,
    'B2',
    'REGULAR',
    1000.00,
    TRUE
),

(
    20206,
    10003,
    'B3',
    'REGULAR',
    1000.00,
    TRUE
);


-- ============================================================
-- 15. SAMPLE BOOKING
-- ============================================================
-- We are NOT inserting a sample booking here.
-- Bookings should be created through BookingService.


-- ============================================================
-- 16. SAMPLE PAYMENT
-- ============================================================
-- We are NOT inserting a sample payment here.
-- Payments should be created through PaymentService.


-- ============================================================
-- 17. VERIFY DATABASE
-- ============================================================

SHOW TABLES;


-- ============================================================
-- 18. VERIFY USERS
-- ============================================================

SELECT *
FROM users;


-- ============================================================
-- 19. VERIFY ADMINS
-- ============================================================

SELECT *
FROM admins;


-- ============================================================
-- 20. VERIFY EVENTS
-- ============================================================

SELECT *
FROM events;


-- ============================================================
-- 21. VERIFY SEATS
-- ============================================================

SELECT *
FROM seats;


-- ============================================================
-- 22. VERIFY BOOKINGS
-- ============================================================

SELECT *
FROM bookings;


-- ============================================================
-- 23. VERIFY PAYMENTS
-- ============================================================

SELECT *
FROM payments;