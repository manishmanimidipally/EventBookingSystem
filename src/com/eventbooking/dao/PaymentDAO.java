package com.eventbooking.dao;

import com.eventbooking.model.Payment;
import java.util.List;

public interface PaymentDAO {

    boolean addPayment(Payment payment);

    Payment getPaymentById(int paymentId);

    Payment getPaymentByBookingId(int bookingId);

    List<Payment> getAllPayments();

    boolean updatePaymentStatus(int paymentId, String status);
}