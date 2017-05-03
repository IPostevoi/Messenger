package hello.url;

import hello.Message;
import hello.models.User;
import hello.Config;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by bakla410 on 03.05.17.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String login() {
        return "login_page.html";
    }

    @MessageMapping("/validateLogin/")
    @SendTo("/response/login/")
    public Message validate(User user) throws Exception {
        //Thread.sleep(4000); // simulated delay

        boolean ifUser = Config.getStorage().ifExists(user.getUsername());
        if (ifUser) {
            return new Message("Status: OK, welcome " + user.getUsername());
        } else {
            return new Message("Status: no such user!");
        }
    }

}
