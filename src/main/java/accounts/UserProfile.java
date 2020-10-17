package accounts;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UserProfile {
    private final String login;
    private final String password;
    private final String email;

    public UserProfile(String login, String pass, String email) {
        this.login = login;
        this.password = pass;
        this.email = email;
    }

    public UserProfile(String login) {
        this.login = login;
        this.password = login;
        this.email = login;
    }

    public UserProfile(String login, String password) {
        this.login = login;
        this.password = password;
        this.email = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
