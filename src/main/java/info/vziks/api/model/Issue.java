package info.vziks.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Class Issue
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String issue;
    private String description;

    public Issue() {
    }

    public Issue(long id, String issue, String description) {
        this.id = id;
        this.issue = issue;
        this.description = description;
    }

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "assignee_id", nullable = false)
    private Assignee assignee;



    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getIssue() {
        return issue;
    }

    public String getDescription() {
        return description;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
