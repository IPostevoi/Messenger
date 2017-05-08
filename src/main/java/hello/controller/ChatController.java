package hello.controller;

import hello.models.Chat;
import hello.Config;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


/**
 * Created by bakla410 on 06.05.17.
 */

@Controller
public class ChatController {

    @PostMapping("/chat/create")
    public String createChat(@RequestParam("chat") String chatName, Principal principal) {
        Integer id = Config.getChat().create(chatName, principal.getName());
        System.out.println(principal.getName());
        return "redirect:/chat/" + id;
    }

    @PostMapping("/chat/addUser")
    public String addUserToChat(@RequestParam("chat") Integer chatid, @RequestParam("username") String username, Principal principal) {
        if (Config.getUser().ifExists(username)) {
            Config.getChatUsers().create(username, chatid);
            return "redirect:/user";
        } else {
            System.out.println("invalid username");
            return "redirect:/user?addUser=error";
        }
    }

    @GetMapping("/chat")
    public String getChat(@RequestParam("id") Integer id, Principal principal) {
        System.out.println(id);
        return "redirect:/chat?id=" + id;
    }

    @GetMapping("/user")
    public String setChatList(Principal principal) {
        List<Chat> list = Config.getChat().listChat(principal.getName());
        System.out.println(list.get(0).getName());
        return "user_page";
    }

}
