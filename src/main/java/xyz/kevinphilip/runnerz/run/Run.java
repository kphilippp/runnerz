package xyz.kevinphilip.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;


// A record also has getters and equals and hashcode function; however it is immutable -> no setters
public record Run(
    Integer id,

    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,

    @Positive
    Integer miles,
    Location location
) {

    public Run {
        if (completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after started on");
        }
    }


}
