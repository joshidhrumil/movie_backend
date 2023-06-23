package com.demo.movie.service;

import com.demo.movie.Model.ShowResponse;
import com.demo.movie.Model.Shows;
import com.demo.movie.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ShowResponse createShow(Shows shows) {
        Boolean value = true;
        Shows createdShow= new Shows();
        System.out.println("show time:" +shows.getStartTime() +"to"+ shows.getEndTime());
        createdShow.setStartTime(shows.getStartTime());
        createdShow.setEndTime(shows.getEndTime());
        createdShow.setSoftDelete(value);
        System.out.println("show time:" +createdShow.getStartTime() +"to"+ createdShow.getEndTime());
        showRepository.save(createdShow);
        return new ShowResponse("Show Created Succesfully",""+createdShow.getStartTime(),""+createdShow.getEndTime());
    }

    @Override
    public List<Shows> getAllShowRecord()
    {
        return showRepository.findAll();
    }

    @Override
    public List<Shows> getAllShows() {
        List<Shows> ShowList;
        List<Shows> ReturnShows = new ArrayList<>();
        ShowList= showRepository.findAll();
        for(int i=0; i<ShowList.size(); i++)
        {
            if(ShowList.get(i).isSoftDelete()==true)
            {
                ReturnShows.add(ShowList.get(i));
            }
        }
        return ReturnShows;
    }

    @Override
    public String deleteShows() {
        showRepository.deleteAll();
        return "All Shows Permanently Deleted";

    }

    @Override
    public String deleteShowsById(String id){
        List<Shows> show;
        Query query = new Query();
        query.addCriteria(Criteria.where("showId").is(id));
        show = mongoTemplate.find(query,Shows.class);
        System.out.println("Show size:" + show.size());
        for(int i=0 ; i<show.size() ; i++)
        {
            Boolean value = show.get(i).isSoftDelete();
            System.out.println("Value:" +value);
            if (value == true)
            {
                value= false;
                show.get(i).setSoftDelete(value);
                System.out.println("ValueEdited:" +show.get(i).isSoftDelete());
                showRepository.save(show.get(i));
                return "Show Deleted Succesfully:-  " +show.get(i).getShowId();
            }
            else
            {
                return "Show Not Found";
            }
        }
        return null;
    }
}
