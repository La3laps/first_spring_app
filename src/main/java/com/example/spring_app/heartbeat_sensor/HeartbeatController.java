package com.example.spring_app.heartbeat_sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    @SuppressWarnings("unused")
    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @GetMapping("/heartbeat")
    public int getHeartBeat() {
        RandomHeartbeat randomHeartbeat = new RandomHeartbeat();
        return randomHeartbeat.get();
    }
}