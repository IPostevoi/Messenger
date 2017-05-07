package hello.abstracts;

import hello.models.Message;
import hello.models.User;
import hello.models.Chat;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bakla410 on 07.05.17.
 */
public interface ChatDAO {

    void setDataSource(DataSource ds);

    void create(String chat, String content, String type, Long senderId);

    User getChat(String chat, String content, Long senderId);

    List<Chat> listChat(Long senderId);

    boolean ifExists(String chat, String content);
}
