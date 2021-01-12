package info.vziks.api.controller;

import info.vziks.api.model.Issue;
import info.vziks.api.repository.IssueRepository;
import info.vziks.api.service.IssueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class FluxController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@RestController
public class FluxController {

    Logger logger = LogManager.getLogger(IssieController.class);

    @Autowired
    private IssueRepository issueRepository;

//    @GetMapping(value = "/info/")
//    private Flux<Issue> getAllEmployees() {
//        return issueRepository.findAll();
//    }

    private static Double randomDouble() {
        return ThreadLocalRandom.current().nextDouble(1,200);

    }

}
