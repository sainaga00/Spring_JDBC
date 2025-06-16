package com.db.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class HomeController
{
    private final UserService service;

    public HomeController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        service.addUser(user.getName(),user.getEmail());
        return "User added successfully!";
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }
}
