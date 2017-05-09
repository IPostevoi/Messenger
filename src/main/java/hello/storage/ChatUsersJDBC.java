package hello.storage;

import hello.abstracts.BaseSource;
import hello.abstracts.ChatUsersDAO;
import hello.models.User;

import java.util.List;

/**
 * Created by bakla410 on 08.05.17.
 */
public class ChatUsersJDBC extends BaseSource implements ChatUsersDAO {

    public void create(String username, Integer chatId) {
        String SQL = "insert into ChatUsers (username, chatId) values (?, ?)";
        jdbcTemplateObject.update(SQL, username, chatId);
        System.out.println("Created Record in ChatUsers username = " + username + " chatId = " + chatId);
    }

    public boolean ifExists(String username, Integer chatId) {
        String SQL = "select count(1) from ChatUsers where username = ? and chatId = ?";
        Integer count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username, chatId }, Integer.class);
        return count != null && count > 0;
    }

    public List<User> listUsers(Integer chatId) {
        String SQL = "select * from ChatUsers where chatId = ?";
        List<User> users = jdbcTemplateObject.query(SQL, new Object[]{chatId}, new ChatUsersMapper());
        return users;
    }
}
