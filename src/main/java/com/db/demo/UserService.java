package com.db.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepo up;

    public UserService(UserRepo up)
    {
        this.up = up;
    }

    public User addUser(String name, String email)
    {
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        return up.save(u);
    }

    public List<User> findAll()
    {
        return up.findAll();
    }
}
