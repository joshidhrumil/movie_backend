package com.demo.movie.Controller;

import com.demo.movie.Model.ShowResponse;
import com.demo.movie.Model.Shows;
import com.demo.movie.Model.Users;
import com.demo.movie.Repository.ShowRepository;
import com.demo.movie.service.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/shows")
public class ShowController extends ShowServiceImpl{


    @Autowired
    ShowServiceImpl showServiceImpl;

    @PostMapping(value = "/createShow")
    public ShowResponse createShow(@RequestBody Shows shows) {
        return showServiceImpl.createShow(shows);
    }

    @GetMapping(value = "/getAllShows")
    public List<Shows> getAllShows()
    {
        return showServiceImpl.getAllShows();
    }

    @DeleteMapping(value = "/deleteShows")
    public String deleteShow()
    {
        return showServiceImpl.deleteShows();
    }

    @PostMapping(value = "/deleteShowsByID/{id}")
    public String deleteShowById(@PathVariable String id)
    {
       return showServiceImpl.deleteShowsById(id);
    }

    @GetMapping(value = "/getAllShowRecords")
    public List<Shows> getAllShowsRecords()
    {
        return showServiceImpl.getAllShowRecord();
    }
}
