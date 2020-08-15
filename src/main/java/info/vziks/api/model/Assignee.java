package info.vziks.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Class Assignee
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Entity
public class Assignee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.EAGER)
//    @JsonSerialize(using = CustomListSerializer.class)
    @JsonBackReference
    private List<Issue> issues;

    public String getName() {
        return name;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
