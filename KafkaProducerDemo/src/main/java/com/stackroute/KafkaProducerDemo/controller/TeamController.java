package com.stackroute.KafkaProducerDemo.controller;

import com.stackroute.KafkaProducerDemo.model.Team;
import com.stackroute.KafkaProducerDemo.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamServiceImpl service;

    @PostMapping("/add/publish")
    public ResponseEntity<?> addTeam(@RequestBody Team team){
        Team team1
                 = service.addTeam(team);
        return new ResponseEntity<Team>(team1, HttpStatus.CREATED);
    }

}
