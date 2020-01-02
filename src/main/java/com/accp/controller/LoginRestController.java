package com.accp.controller;

import com.accp.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class LoginRestController {

    @GetMapping
    public Map<String,Object> login(String userName, String userPassword, HttpSession session){
        User users = new User(1,userName,userPassword);
        session.setAttribute("user",users);
        Map<String,Object> map = new HashMap<>();
        map.put("user", users);
        map.put("token", session.getId());
        return map;
    }
}
