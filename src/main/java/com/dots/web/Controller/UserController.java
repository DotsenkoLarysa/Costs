package com.dots.web.Controller;

import com.dots.persistence.model.User;
import com.dots.service.UserService;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController{

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/show_all")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "list-users";
    }

    @GetMapping(path={"/edit", "/edit/{id}"})
    public String editUserById(Model model, @PathVariable("id") Long user_id)
            throws RecordNotFoundException
    {
        if (user_id != null) {
            User user = userService.getUserById(user_id);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return "add-edit-user";
    }

    @PostMapping("/create")
    public String createOrUpdateUser(User user){
        userService.createOrUpdateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}