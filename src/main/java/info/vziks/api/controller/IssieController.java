package info.vziks.api.controller;

import info.vziks.api.model.Issue;
import info.vziks.api.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IssueService issueService;

    @RequestMapping("/issues")
    public List<Issue> allIssues() {
        return this.issueService.getAllIssues();
    }
}
