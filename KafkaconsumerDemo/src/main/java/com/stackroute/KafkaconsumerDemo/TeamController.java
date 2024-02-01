package com.stackroute.KafkaconsumerDemo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    Gson gson;

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume(String Team){
//        System.out.println("Consumed Message: " + Team);
           Team obj = gson.fromJson(Team, Team.class);
           System.out.println("Consumed Message: " + obj.getTeamId() +"  "+ obj.getTeamName() +"  "+ obj.getCountry());

    }
}
