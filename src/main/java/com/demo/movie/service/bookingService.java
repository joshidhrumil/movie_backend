package com.demo.movie.service;

import com.demo.movie.Model.BookingResponse;
import com.demo.movie.Model.Bookings;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public abstract interface bookingService{

    public BookingResponse createBooking(@RequestBody Bookings bookings);
    public String deletebookings();
    public List<Bookings> getAllBookings();
    public Optional<Bookings> getBookingByID(@PathVariable String id);
    public  List<Bookings> getBookingsByUserName(@PathVariable String Username);
    public BookingResponse deleteBookingById(@PathVariable String id);
    public List<Bookings> getAllBookingRecords();

}
