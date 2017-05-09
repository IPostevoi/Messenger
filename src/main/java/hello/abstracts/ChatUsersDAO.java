package hello.abstracts;


import hello.models.User;

import java.util.List;

/**
 * Created by bakla410 on 08.05.17.
 */
public interface ChatUsersDAO {

    void create(String username, Integer chatId);

    boolean ifExists(String username, Integer chatId);

    List<User> listUsers(Integer chatId);
}
