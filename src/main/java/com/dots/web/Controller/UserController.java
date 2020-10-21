package com.dots.web.Controller;

import com.dots.persistence.model.User;
import com.dots.persistence.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    @GetMapping("/name/{username}")
    public List findByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User Id:" + id));}

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
        model.addAttribute("user", user);
        return "update-user";

    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setUser_id(id);
            return "update-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}