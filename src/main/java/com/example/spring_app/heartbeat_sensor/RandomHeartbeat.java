package com.example.spring_app.heartbeat_sensor;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    @Override
    public int get() {
        try {
            SecureRandom randNum = new SecureRandom();
            return randNum.nextInt(100);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

}