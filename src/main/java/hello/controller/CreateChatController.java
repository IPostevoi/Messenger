package hello.controller;

import hello.models.Chat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by bakla410 on 06.05.17.
 */

@Controller
public class CreateChatController {

//    @GetMapping("/user")
//    @ResponseBody
//    public void setModel(Model model) {
//        model.addAttribute("chat", new Chat());
//    }

    @PostMapping("/chat/create")
    public String createChat(@RequestParam("chat") String chatName) {
        System.out.println(chatName);
        return "redirect:/user";
    }
}
