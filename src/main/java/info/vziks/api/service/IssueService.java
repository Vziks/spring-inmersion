package info.vziks.api.service;

import info.vziks.api.model.Issue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Class IssueService
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Service
public class IssueService {

    private List<Issue> issueList = new ArrayList<>(
            Arrays.asList(
                    new Issue("1", "question 1?", "desc1"),
                    new Issue("2", "question 2?", "desc2"),
                    new Issue("3", "question 3?", "desc3"),
                    new Issue("4", "question 4?", "desc4")
            ));

    public List<Issue> getAllIssues() {
        return issueList;
    }

    public Issue getIssueById(String id) {
        Optional<Issue> optionalIssue = issueList.stream().filter(i -> i.getId().equals(id)).findFirst();
        return optionalIssue.orElse(null);
    }

    public void addIssue(Issue issue) {
        issueList.add(issue);
    }

    public void updateIssue(String id, Issue issue) {
        for (int i = 0; i < issueList.size(); i++) {
            if (id.equals(issueList.get(i).getId())) {
                issueList.set(i, issue);
                return;
            }
        }
    }
}
