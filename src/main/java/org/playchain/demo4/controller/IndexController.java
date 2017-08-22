package org.playchain.demo4.controller;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Liu on 2017/8/21.
 */
@RestController
@EnableResourceServer
public class IndexController {

    @RequestMapping("/tokencall")
    public String secureCall() {
        return "success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
    }
}
