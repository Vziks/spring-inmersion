package info.vziks.api.jdbc.simple.dao;

import info.vziks.api.jdbc.simple.IssueDao;
import info.vziks.api.model.Issue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class IssueDaoImplementation
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class IssueDaoImplementation implements IssueDao {

    private static Logger logger = LoggerFactory.getLogger(IssueDaoImplementation.class);

    static {
        try {
            Class.forName("org.hibernate.dialect.PostgreSQLDialect");
        } catch (ClassNotFoundException e) {
            logger.error("Problem loading DB Driver", e);
        }
    }


    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/skeleton",
                "vziks", "");
    }

    @Override
    public List<Issue> findAll() {
        List<Issue> result = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement =
                     connection.createStatement()) {
            ;
            ResultSet resultSet = statement.executeQuery("select * from issue");
            IterateAndFillList(result, resultSet);
        } catch (SQLException ex) {
            logger.error("Problem when executing SELECT!", ex);
        }
        return result;
    }

    private void IterateAndFillList(List<Issue> result, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Issue issue = new Issue();
            issue.setId(resultSet.getLong("id"));
            issue.setIssue(resultSet.getString("issue"));
            issue.setDescription(resultSet.getString("description"));
            issue.setType(resultSet.getInt("type"));
            result.add(issue);
        }
    }


    @Override
    public void insert(Issue issue) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into issue (issue, description, type) values (?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, issue.getIssue());
            statement.setString(2, issue.getDescription());
            statement.setInt(3, issue.getType());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                issue.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException ex) {
            logger.error("Problem executing INSERT", ex);
        }
    }

    @Override
    public List<Issue> findByIssueName(String issue) {
        List<Issue> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from issue where issue.issue=?");
            preparedStatement.setString(1, issue);
            ResultSet resultSet = preparedStatement.executeQuery();

            IterateAndFillList(result, resultSet);

        } catch (SQLException ex) {
            logger.error("Problem executing select", ex);
        }

        return result;

    }

    @Override
    public String findIssueById(Long id) {
        String str = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from issue where id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            str = resultSet.getString("issue");
        } catch (SQLException ex) {
            logger.error("Problem executing select", ex);
        }

        return str;
    }


    @Override
    public void update(Issue issue) {

    }

    @Override
    public void delete(Long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from issue where id=?");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException ex) {
            logger.error("Problem executing DELETE", ex);
        }
    }


    @Override
    public void insertWithAssign(Issue issue) {

    }
}
