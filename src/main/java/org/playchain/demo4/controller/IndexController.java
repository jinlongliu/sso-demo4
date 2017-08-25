package org.playchain.demo4.controller;

import org.playchain.demo4.mapper.UserMapper;
import org.playchain.demo4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Liu on 2017/8/21.
 */
@RestController
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/tokencall")
    public String secureCall() {
        return "success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/data")
    List<User> getData() {
        return userMapper.selectByExample(null);
    }
}
