package info.vziks.api.jdbc.simple;

import info.vziks.api.model.Issue;

import java.util.List;

/**
 * Interface IssueDao
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface IssueDao {
    List<Issue> findAll();
    List<Issue> findByIssueName(String issue);
    String findIssueById(Long id);
    void insert(Issue issue);
    void update(Issue issue);
    void delete(Long id);
    List<Issue> findAllWithAlbums();
    void insertWithAssign(Issue issue);


    static void me(){
        System.out.println("@@@");
    }
}
