package com.example.spring_app.heartbeat_sensor;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    @Override
    public int get() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}