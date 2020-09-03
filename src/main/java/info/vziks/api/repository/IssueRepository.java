package info.vziks.api.repository;

import info.vziks.api.model.Issue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface IssueRepository
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface IssueRepository extends CrudRepository<Issue, Long> {

    List<Issue> findByAssigneeId(Long id);

    @Query(
            value = "SELECT COUNT(*) FROM Issue i",
            nativeQuery = true)
    long getIssueCount();

}
