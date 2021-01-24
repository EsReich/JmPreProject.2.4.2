package web.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.crud.entity.User;
import web.crud.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "all_users";
    }

    @GetMapping("/add-new-user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());

        return "user_info";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveOrUpdateUser(user);
        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateInfo(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("patchedUser", userService.getUser(id));

        return "user_update";
    }

    @PatchMapping("/")
    public String updateUser(@ModelAttribute("patchedUser") User user) {
//        userService.saveOrUpdateUser(user);
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteInfo(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("deletedUser", userService.getUser(id));
        return "user_delete";
    }

    @DeleteMapping("/")
    public String deleteUser(@ModelAttribute("deletedUser") User user) {
        userService.deleteUser(user);
        return "redirect:/";
    }
}
