package xyz.kevinphilip.runnerz;

import org.springframework.stereotype.Component;

// component tag means this class is avail to spring
@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Hello to the Spring Boot Application";
    }

}
