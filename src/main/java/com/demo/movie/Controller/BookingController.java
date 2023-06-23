package com.demo.movie.Controller;

import com.demo.movie.Model.BookingResponse;
import com.demo.movie.Model.Bookings;
import com.demo.movie.Model.Movies;
import com.demo.movie.Repository.BookingRepository;
import com.demo.movie.service.bookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/bookMovieTickets")
public class BookingController extends bookingServiceImpl {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    bookingServiceImpl bookingImpl;

    @PostMapping(value = "/bookTickets")
    public BookingResponse createdBooking(@RequestBody Bookings bookings) {
           return bookingImpl.createBooking(bookings);
    }

    @DeleteMapping(value = "/deleteBooking")
    public String deletebooking() {
        bookingImpl.deletebookings();
        return "Bookings Deleted";
    }

    @GetMapping(value = "/getAllBookings")
    public List<Bookings> getAllBooking()
    {
      return bookingImpl.getAllBookings();
    }

    @GetMapping(value = "/getAllBookingsRecords")
    public List<Bookings> getAllBookingRecord()
    {
        return bookingImpl.getAllBookingRecords();
    }


    @GetMapping(value = "/getBookingByID/{id}")
    public Optional<Bookings> getBookingsByID(@PathVariable String id) {
        return bookingImpl.getBookingByID(id);
    }

    @GetMapping(value = "/getBookingsByName/{Username}")
    public  List<Bookings> getMovieByName(@PathVariable String Username) {
        return bookingImpl.getBookingsByUserName(Username);
    }

    @GetMapping(value = "/deleteBookingById/{id}")
    public BookingResponse deleteBookingsById(@PathVariable String id)
    {
        return bookingImpl.deleteBookingById(id);
    }
}
