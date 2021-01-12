package info.vziks.api.controller;

import info.vziks.api.model.Issue;
import info.vziks.api.service.IssueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class IssieController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@RestController
public class IssieController {

    Logger logger = LogManager.getLogger(IssieController.class);

    @Autowired
    private IssueService issueService;

    @RequestMapping(path = "/issues")
    public List<Issue> allIssues() {
        Connection.Response response;

        try {
            response = Jsoup.connect("http://www.example.com/login")
                    .data("username", "myUsername",
                            "password", "myPassword")
                    .method(Connection.Method.POST)
                    .execute();

            Map<String, String> loginCookies = response.cookies();

            Connection.Response newRes = Jsoup.connect("url")
                    .cookies(loginCookies)
                    .method(Connection.Method.GET)
                    .execute();


            System.out.println(newRes.statusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.info("Request /issues");
        return issueService.getAllIssues();
    }

    @RequestMapping(path = "/issues/assignee/{id}")
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


    @RequestMapping(value = "/issues/reverse", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reverseIssue() {
        issueService.reverseBool();
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
