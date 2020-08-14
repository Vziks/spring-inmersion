package info.vziks.api.model;

/**
 * Class Issue
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Issue {
    private String id;
    private String issue;
    private String description;

    public Issue(String id, String issue, String description) {
        this.id = id;
        this.issue = issue;
        this.description = description;
    }

    public Issue() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getIssue() {
        return issue;
    }

    public String getDescription() {
        return description;
    }
}
