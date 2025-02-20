package xyz.kevinphilip.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {
    // The following is temp, we are using an in memory way to store runs until we use db
    // We declare List using ArrayList intead of an Array because it is dynamic and will adjust size accordingly.
    // We also declare the object as a List which is a higher level of abstraction just in case we want to switch over to a LinkedList for ex
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findRunById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Integer id, Run run){
        Optional<Run> existingRun = findRunById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id() == id);
    }



    @PostConstruct
    public void init() {
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now(), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now(), 10, Location.INDOOR));
    }




}
