package xyz.kevinphilip.runnerz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Controllers are like traffic cops, they manage flow between the model and the view
// For now, we will create an in memory representation of our runs using a list and then later transfer that to a database
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    @Autowired
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findRunByID(@PathVariable Integer id) {

        Optional<Run> run = runRepository.findRunById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run with id " + id + " not found()");
        }
        return run.get();

    }

    // post
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }

    // put
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable Integer id, @RequestBody Run run) {
        runRepository.update(id, run);
    }

    // delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
