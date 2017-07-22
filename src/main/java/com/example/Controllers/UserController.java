package com.example.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by HSEQ on 27/03/2017.
 */
@RestController
public class UserController {
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
}
