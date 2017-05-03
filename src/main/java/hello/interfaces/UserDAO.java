package hello.interfaces;

import hello.models.User;

import java.util.List;
import javax.sql.DataSource;

/**
 * Created by bakla410 on 03.05.17.
 */
public interface UserDAO {

    void setDataSource(DataSource ds);

    void create (String username, String password);

    User getUser(String username);

    List<User> listUsers();

    void delete(Integer id);

    boolean ifExists(String username);
}
