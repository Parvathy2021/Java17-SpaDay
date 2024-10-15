package org.launchcode.controllers;

import jakarta.validation.constraints.Email;
import org.launchcode.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("user", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("error", "incorrect Password");

            return "/user/add";
        }

        return "/user/index";
    }

}
