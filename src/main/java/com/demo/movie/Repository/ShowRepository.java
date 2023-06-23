package com.demo.movie.Repository;

import com.demo.movie.Model.Shows;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends MongoRepository<Shows,String> {
}
