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
        return issueService.getAllIssues();
    }

    @RequestMapping("/issues/assignee/{id}")
    public List<Issue> getByAssigneeId(@PathVariable Long id) {
        return issueService.getByAssigneeId(id);
    }


    @RequestMapping("/issues/{id}")
    public Issue getIssue(@PathVariable Long id) {
        Issue issue = issueService.getIssueById(id);
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
        issueService.addIssue(issue);
    }

    @RequestMapping(value = "/issues/count", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public long countIssue() {
        return issueService.countIssues();
    }

    @RequestMapping(value = "/issues", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateIssue(@RequestBody Issue issue) {
        issueService.updateIssue(issue);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
    }
}
