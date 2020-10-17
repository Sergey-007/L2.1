package dao;

import accounts.UserProfile;
import executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserProfile get(long id)  {
        try {
            return executor.execQuery("select login, password from users where id=" + id, result -> {
                result.next();
                return new UserProfile(result.getString(1), result.getString(2));
            });
        } catch (SQLException throwables) {
            return null;
        }
    }

    public UserProfile getUserByLogin(String login) {
        try {
            return executor.execQuery("select login, password from users where login='" + login + "'", result -> {
                result.next();
                return new UserProfile(result.getString(1), result.getString(2));
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void insertUser(String login, String password) {
        try {
            executor.execUpdate("insert into users (login, password) values ('" + login + "', '" + password + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
