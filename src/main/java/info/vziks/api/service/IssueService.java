package info.vziks.api.service;

import info.vziks.api.model.Issue;
import info.vziks.api.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> getAllIssues() {
        List<Issue> issues = new ArrayList<>();
        issueRepository.findAll().forEach(issues::add);
        return issues;
    }

    public Issue getIssueById(String id) {
        Optional<Issue> optionalIssue = issueRepository.findById(id);
        return optionalIssue.orElse(null);
    }

    public void addIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public void updateIssue(Issue issue) {
        issueRepository.save(issue);
//        for (int i = 0; i < issueList.size(); i++) {
//            if (id.equals(issueList.get(i).getId())) {
//                issueList.set(i, issue);
//                return;
//            }
//        }
    }

    public void deleteIssue(String id) {
//        issueList.removeIf(issue -> id.equals(issue.getId()));
        Issue issue = this.getIssueById(id);
        issueRepository.delete(issue);
        // or
//        issueRepository.deleteById(id);

    }
}
