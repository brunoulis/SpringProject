package bruno.luis.springproject.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bruno.luis.springproject.model.User;
import bruno.luis.springproject.service.IUserService;
import ch.qos.logback.classic.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    public String create() {
        return "user/register";
    }

    @PostMapping("/save")
    public String save(User user) {
        log.info("Guardando usuario: " + user);
        user.setType("USER");
        userService.save(user);
        return "redirect:/";
    }

}
