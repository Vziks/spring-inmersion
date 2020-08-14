package info.vziks.api.controller;

import info.vziks.api.model.Issue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Class IssieController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@RestController
public class IssieController {


    @RequestMapping("/issues")
    public List<Issue> allIssues() {

        return Arrays.asList(
                new Issue(1, "question 1?", "desc1"),
                new Issue(2, "question 2?", "desc2"),
                new Issue(3, "question 3?", "desc3"),
                new Issue(4, "question 4?", "desc4")
        );
    }
}
