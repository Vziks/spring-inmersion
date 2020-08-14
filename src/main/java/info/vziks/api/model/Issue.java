package info.vziks.api.model;

/**
 * Class Issue
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Issue {
    private int id;
    private String issue;
    private String description;

    public Issue(int id, String issue, String description) {
        this.id = id;
        this.issue = issue;
        this.description = description;
    }

    public Issue() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getIssue() {
        return issue;
    }

    public String getDescription() {
        return description;
    }
}
