package info.vziks.api.repository;

import info.vziks.api.model.Issue;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface IssueRepository
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public interface IssueRepository extends CrudRepository<Issue, Long> {

}
