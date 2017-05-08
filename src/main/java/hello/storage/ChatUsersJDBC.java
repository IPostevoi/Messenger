package hello.storage;

import hello.abstracts.BaseSource;
import hello.abstracts.ChatUsersDAO;

/**
 * Created by bakla410 on 08.05.17.
 */
public class ChatUsersJDBC extends BaseSource implements ChatUsersDAO {

    public void create(String username, Integer chatId) {
        String SQL = "insert into ChatUsers (username, chatId) values (?, ?)";
        jdbcTemplateObject.update(SQL, username, chatId);
        System.out.println("Created Record in ChatUsers username = " + username + " chatId = " + chatId);
    }
}
