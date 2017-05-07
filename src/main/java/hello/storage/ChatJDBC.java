package hello.storage;

/**
 * Created by bakla410 on 07.05.17.
 */

import java.util.List;
import javax.sql.DataSource;

import hello.abstracts.BaseSource;
import hello.abstracts.ChatDAO;
import hello.models.Chat;
import hello.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class ChatJDBC extends BaseSource implements ChatDAO{

    public void setDataSource(DataSource ds) {

    }

    public void create(String chat, String content, String type, Long senderId) {

    }

    public User getChat(String chat, String content, Long senderId) {

    }

    public List<Chat> listChat(Long senderId) {

    }
    public boolean ifExists(String chat, String content) {

    }
}
