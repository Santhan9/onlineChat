package com.OnlineChat.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class AppController {

    Logger log = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/")
    public ResponseEntity<String> getHome(){
        log.info("new request came to home");
        return new ResponseEntity<>("<html>" +
                "<body>" +
                "<h1>" +
                "Welcome</h1>" +
                "</body></html>", HttpStatus.OK);

    }

    @GetMapping("/sessionToken")
    public void getSessionToken(@RequestParam("username")String username){



    }
}
