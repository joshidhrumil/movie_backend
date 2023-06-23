package com.demo.movie.service;

import com.demo.movie.Model.*;
import com.demo.movie.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class bookingServiceImpl implements bookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public BookingResponse createBooking(Bookings bookings) {

        // Checking That the User for Whom Tickets are Booked Exists or not //

        String userId = bookings.getUser().getId();
        List<Users> user;
        Query query =new Query();
        query.addCriteria(Criteria.where("id").is(userId));
        user = mongoTemplate.find(query,Users.class);
        for(int i=0 ; i<user.size() ; i++)
        {
            boolean UserSoftDelete = user.get(i).isSoftDelete();
            if (user.get(i).isSoftDelete())
            {

                // Checking That the Movie for Which Tickets are Booked Exists or not //

                String movieId = bookings.getMovie().getMovieid();
                List<Movies> movie;
                Query query1 =new Query();
                query1.addCriteria(Criteria.where("movieid").is(movieId));
                movie = mongoTemplate.find(query1,Movies.class);
                for (int j=0 ; j<movie.size() ; j++) {
                    boolean MovieSoftDelete = movie.get(j).isSoftDelete();
                    float cost = movie.get(j).getPrice();
                    if (movie.get(j).isSoftDelete()) {

                        // Checking That the Show for Which Tickets are Booked Exists or not //

                        String ShowId = bookings.getMovie().getShow().getShowId();
                        List<Shows> show;
                        Query query2 = new Query();
                        query2.addCriteria(Criteria.where("showId").is(ShowId));
                        show = mongoTemplate.find(query2,Shows.class);
                        for (int k=0; k<show.size() ; k++) {
                            boolean ShowSoftDelete = show.get(k).isSoftDelete();
                            System.out.println("ShowsoftDelete"+ShowSoftDelete);
                            if (show.get(k).isSoftDelete()) {

                                // Booking Tickets //

                                Bookings createdBookings= new Bookings();
                                createdBookings.setUser(bookings.getUser());
                                createdBookings.setMovie(bookings.getMovie());
                                createdBookings.setSoftDelete(true);
                                createdBookings.setQuantity(bookings.getQuantity());
                                createdBookings.setTotal(+bookings.getQuantity()*cost);
                                Bookings bv= bookingRepository.save(createdBookings);
                                return new BookingResponse(""+createdBookings.getBookingId(),"Booking Succesfull");
                           }
                           else
                           {
                               return new BookingResponse("No Shows Available!!",""+movie.get(k).getMovieName());
                           }
                       }
                   }
                   else {
                       return new BookingResponse("Movie Not Available Currently!!",""+movie.get(j).getMovieName());
                   }
               }
           }
           else if(user == null || user.get(i).isSoftDelete()==false ) {
               return new BookingResponse("No Such User Exists Please SignUp!! ",""+user.get(i).getName());
           }
       }
        return new BookingResponse("Booking Failed!!","");
    }

    @Override
    public String deletebookings() {
        bookingRepository.deleteAll();
        return "Bookings Deleted";
    }

    @Override
    public BookingResponse deleteBookingById(String id)
    {
        List<Bookings> bookings;
        Query query = new Query();
        query.addCriteria(Criteria.where("bookingId").is(id));
        bookings = mongoTemplate.find(query,Bookings.class);
        for(int i=0 ;i<bookings.size(); i++) {
            if(bookings.get(i).isSoftDelete()) {
                bookings.get(i).setSoftDelete(false);
                bookingRepository.save(bookings.get(i));
                return new BookingResponse("Booking Successfully Deleted",""+bookings.get(i).getBookingId());
            }
            else{
                return new BookingResponse("No Such Bookings Exists","");
            }
        }
        return null;
    }

    @Override
    public List<Bookings> getAllBookings() {
        List<Bookings> bookings;
        bookings = bookingRepository.findAll();
        List<Bookings> returnList= new ArrayList<>();
        for (int i=0; i<bookings.size(); i++) {
            if (bookings.get(i).isSoftDelete()) {
                if (bookings.get(i).getUser().isSoftDelete() && bookings.get(i).getMovie().isSoftDelete() && bookings.get(i).getMovie().getShow().isSoftDelete()) {
                        returnList.add(bookings.get(i));
                }
            }
        }
        return returnList;
    }

    @Override
    public List<Bookings> getAllBookingRecords()
    {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Bookings> getBookingByID(String id) {
        Optional<Bookings> bb= bookingRepository.findById(id);
        return bb;
    }

    @Override
    public  List<Bookings> getBookingsByUserName(String Username){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(Username));
        List<Bookings> booking = mongoTemplate.find(query, Bookings.class);
        return booking;
    }
}
