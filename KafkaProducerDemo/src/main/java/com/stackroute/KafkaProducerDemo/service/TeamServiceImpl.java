package com.stackroute.KafkaProducerDemo.service;

import com.google.gson.Gson;
import com.stackroute.KafkaProducerDemo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamServiceDao {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson gson;

    private static final String TOPIC = "NewTopic";

    public Team addTeam(Team team) {

        kafkaTemplate.send(TOPIC, gson.toJson(team));
        return team;
    }


}
