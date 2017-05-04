package hello.abstracts;

import hello.models.Message;
import hello.models.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bakla410 on 04.05.17.
 */
public interface MessageDAO {

    void setDataSource(DataSource ds);

    void create(String chat, String content, String type, Long senderId);

    User getMessage(String chat, String content, Long senderId);

    List<Message> listMessages(Long senderId);

    boolean ifExists(String chat, String content);
}
