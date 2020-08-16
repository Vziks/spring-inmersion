package info.vziks.api.service;

import info.vziks.api.model.Issue;
import info.vziks.api.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Issue getIssueById(Long id) {
        Optional<Issue> optionalIssue = issueRepository.findById(id);
        return optionalIssue.orElse(null);
    }

    public void addIssue(Issue issue) {
        Issue issueTmp = null;
        try {
            issueTmp = (Issue) issue.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        issueRepository.save(Objects.requireNonNull(issueTmp));
    }

    public void updateIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public void deleteIssue(Long id) {
        Issue issue = getIssueById(id);
        issueRepository.delete(issue);
    }

    public List<Issue> getByAssigneeId(Long id) {
//        List<Issue> issues = new ArrayList<>();
        return issueRepository.findByAssigneeId(id);
//        return issues;

    }
}
