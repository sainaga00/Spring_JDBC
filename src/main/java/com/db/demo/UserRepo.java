package com.db.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo
{
    private final JdbcTemplate temp;

    public UserRepo(JdbcTemplate temp)
    {
        this.temp = temp;
    }

    public int save(User u)
    {
        return temp.update("insert into users(name,email) values (?,?)",
        u.getName(),u.getEmail());
    }

    public List<User> findAll()
    {
        return temp.query("select * from users",userMap);
    }

    private final RowMapper<User> userMap = (rs, rowNum) -> {

        User u = new User();
        u.setId(rs.getInt("id"));
        u.setEmail(rs.getString("name"));
        u.setName(rs.getString("email"));
        return u;
    };

}
