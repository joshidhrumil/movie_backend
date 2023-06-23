package com.demo.movie.Repository;

import com.demo.movie.Model.Bookings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Bookings,String> {
}
