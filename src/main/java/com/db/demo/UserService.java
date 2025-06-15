package com.db.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private UserRepo up;
    public UserService(UserRepo up)
    {
        this.up = up;
    }

    public void addUser(User user)
    {
        up.save(user);
    }

    public List<User> getAll()
    {
        return up.findAll();
    }
}
