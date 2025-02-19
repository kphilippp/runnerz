package xyz.kevinphilip.runnerz.run;

import java.time.LocalDateTime;


// A record also has getters and equals and hashcode function; however it is immutable -> no setters
public record Run(
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
) {
}
