package hello.controller;

import hello.models.Chat;
import hello.Config;
import hello.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        Config.getChatUsers().create(principal.getName(), id);
        System.out.println(principal.getName());
        return "redirect:/chat/" + id;
    }

    @PostMapping("/chat/{id}/addUser")
    public String addUserToChat(HttpServletRequest request, @RequestParam("username") String username, Principal principal) {
        String path = request.getRequestURI();
        String[] relPath = path.split("/");
        Integer chatId = Integer.parseInt(relPath[2]);
        if (Config.getUser().ifExists(username)) {
            if (!Config.getChatUsers().ifExists(username, chatId)) {
                Config.getChatUsers().create(username, chatId);
            }
            return "redirect:/chat/" + chatId;
        } else {
            System.out.println("invalid username");
            return "redirect:/chat/" + chatId + "?addUserError";
        }
    }

    @GetMapping("/chat/{id}")
    public ModelAndView getChat(HttpServletRequest request, Principal principal) {
        String path = request.getRequestURI();
        String[] split = path.split("/");
        Integer chatId = Integer.parseInt(split[split.length - 1]);
        if (Config.getChatUsers().ifExists(principal.getName(), chatId)) {
            ModelAndView mav = new ModelAndView("chat_page");
            mav.addObject("chatId", split[split.length - 1]);
            List<User> users = Config.getChatUsers().listUsers(chatId);
            mav.addObject("chatUsers", users);
            return mav;
        } else {
            return new ModelAndView("access_denied");
        }
    }

    @GetMapping("/user")
    public String setChatList(Principal principal) {
        List<Chat> list = Config.getChat().listChat(principal.getName());
        System.out.println(list.get(0).getName());
        return "user_page";
    }

}
