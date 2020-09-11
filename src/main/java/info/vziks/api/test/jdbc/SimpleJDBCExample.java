package info.vziks.api.test.jdbc;

import info.vziks.api.jdbc.simple.IssueDao;
import info.vziks.api.jdbc.simple.dao.IssueDaoImplementation;
import info.vziks.api.model.Issue;

import java.util.List;


/**
 * Class SimpleJDBCExample
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class SimpleJDBCExample {


    public static void main(String[] args) {
        IssueDao issueDao = new IssueDaoImplementation();

        IssueDao.me();

        List<Issue> list = issueDao.findAll();


        System.out.println("/**findAll**/");

        for (Issue issue :
                list) {
            System.out.println(issue);

        }

        Issue newIssue = new Issue();

        newIssue.setIssue("newIssue");
        newIssue.setDescription("description newIssue");
        newIssue.setType(5);


        issueDao.insert(newIssue);


        System.out.println("/**findAll**/");

        for (Issue issue :
                issueDao.findAll()) {
            System.out.println(issue);

        }


        System.out.println("/**findByIssueName**/");

        for (Issue issue :
                issueDao.findByIssueName("newIssue")) {
            System.out.println(issue);

        }


        System.out.println("/**findByIssueName**/");


        System.out.println(issueDao.findIssueById(1L));

    }
}
