package info.vziks.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class Issue
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Issue implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String issue;
    private String description;
    private boolean active;

    @CreatedDate
    Date createdAt;


    private Date date;

    public
    @LastModifiedDate
    Date modifiedAt;

    @Transient
    int status;

    int type;

    public Issue() {
    }

    public Issue(long id, String issue, String description) {
        this.id = id;
        this.issue = issue;
        this.description = description;
    }

    //    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignee_id", nullable = true)
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
                "id=" + id +
                ", issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", assignee=" + assignee +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Issue newIssue = (Issue) super.clone();
        newIssue.setId(0);
        return newIssue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
