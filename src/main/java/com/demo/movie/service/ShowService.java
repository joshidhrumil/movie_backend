package com.demo.movie.service;

import com.demo.movie.Model.ShowResponse;
import com.demo.movie.Model.Shows;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ShowService {
    public ShowResponse createShow(@RequestBody Shows shows);
    public List<Shows> getAllShows();
    public String deleteShows();
    public String deleteShowsById(@PathVariable String id);
    public List<Shows> getAllShowRecord();

}
