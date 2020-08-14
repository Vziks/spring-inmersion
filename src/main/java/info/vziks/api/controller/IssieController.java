package info.vziks.api.controller;

import info.vziks.api.model.Issue;
import info.vziks.api.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @RequestMapping("/issues/{id}")
    public Issue getIssue(@PathVariable String id) {
        Issue issue = this.issueService.getIssueById(id);
        if (Objects.isNull(issue)) {
            throw new ResourceNotFoundException();
        }
        return issue;
    }

//    @RequestMapping("/issues/{foo}")
//    public Issue getIssueByOtherName(@PathVariable("foo") String id) {
//        return this.issueService.getIssueById(id);
//    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addIssue(@RequestBody Issue issue) {
        this.issueService.addIssue(issue);
    }


    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateIssue(@PathVariable String id, @RequestBody Issue issue) {
        System.out.println(id);
        System.out.println(issue);
        this.issueService.updateIssue(id, issue);
    }
}
