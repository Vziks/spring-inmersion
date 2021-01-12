package info.vziks.api.service;

import info.vziks.api.model.Issue;
import info.vziks.api.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;
    private final IssueRepository issueRepository;

    @Autowired
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

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

    public long countIssues() {
        return issueRepository.count();
    }

    public List<Issue> getByAssigneeId(Long id) {
//        List<Issue> issues = new ArrayList<>();
        return issueRepository.findByAssigneeId(id);
//        return issues;

    }

    public void reverseBool() {
//        Query q=session.createQuery("update User set name=:n where id=:i");
//        q.setParameter("n","Udit Kumar");
//        q.setParameter("i",111);
//
//        int status=q.executeUpdate();
        String fild = "active";
        entityManager.getTransaction();
        entityManager
//                .createQuery("UPDATE Issue SET active = (active = false)")
                .createQuery("update Issue i set i.active = -1 *(Abs(i.active))")
//                .SQL("update Issue i set i.active = NOT i.active")
//                .setParameterList("n",false)
                .executeUpdate();
    }

}
