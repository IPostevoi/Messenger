package hello.controller;

import hello.models.Message;
import hello.models.User;
import hello.Config;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bakla410 on 03.05.17.
 */
@Controller
public class ChatController {

//    @RequestMapping(value = "/")
//    public String login() {
//        return "login_page.html";
//    }
//    @MessageMapping("/validateLogin/")
//    @SendToUser("/queue/login/")
//    public Message validate(User user) throws Exception {
//        boolean ifUser = Config.getStorage().ifExists(user.getUsername());
//        if (ifUser) {
//            return new Message("OK");
//        } else {
//            return new Message("ERROR");
//        }
//    }
//    public void sendMessages(Principal principal) {
//    messagingTemplate
// .convertAndSendToUser(principal.getName(), "/queue/horray", "Horray, " + principal.getName() + "!");
//}


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Message send(Message message) throws Exception {
        return message;


    }


}
