package com.sn.spring.finalex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sn.spring.finalex.model.*;
import com.sn.spring.finalex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private ReservationRepository reservationRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private ObjectMapper objectMapper;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("form", new FormDTO());
        return "customer-form";
    }

    @PostMapping("/submit")
    public String handleSubmit(@ModelAttribute("form") FormDTO form, Model model) throws Exception {
        // Convert to JSON using Jackson
        String json = objectMapper.writeValueAsString(form);
        System.out.println("📦 JSON: " + json);

        // Create Reservation
        Reservation reservation = new Reservation();
        reservation.setId((int) (Math.random() * 10000));
        reservation.setDetails("Passengers: " + form.getNumberOfPassengers() + ", Class: " + form.getTravelClass());
        reservation.setTicketNumber("TKT" + System.nanoTime());
        reservation.setDate(form.getDateOfDeparture() + " " + form.getTime());
        reservationRepository.save(reservation);

        // Create Customer
        Customer customer = new Customer();
        customer.setDetails(form.getFirstName() + " " + form.getLastName());
        customer.setReservation(String.valueOf(reservation.getId()));
        customer.setAddress(form.getPhoneNumber());
        customerRepository.save(customer);

        // Create Payment (optional logic)
        Payment payment = new Payment();
        payment.setId(reservation.getId());
        payment.setAmount(form.getNumberOfPassengers() * 100); // simple calc
        payment.setDate(form.getDateOfDeparture());
        paymentRepository.save(payment);

        model.addAttribute("successMessage", "✅ Customer details successfully saved!");
        return "confirmation";
    }
}
