package com.OnlineChat.app.controller;

import com.OnlineChat.app.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chat")
public class AppController {

    Logger log = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService service;

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
    public ResponseEntity<String> getSessionToken(@RequestParam("username")String username){
        String token = service.generateSessionToken(username);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @GetMapping("/createGroup")
    public ResponseEntity<String> createGroup(@RequestParam("token")String token){
        service.createGroup(token);
        return new ResponseEntity<>("created",HttpStatus.OK);
    }

    @PostMapping("/postmessage")
    public ResponseEntity<String> postMessage(@RequestBody String message,@RequestParam("token")String token){
        service.postMessage(token,message);
        return new ResponseEntity<>("posted",HttpStatus.OK);

    }
    @GetMapping("/match")
    public ResponseEntity<String> match(){
        service.match();
        return new ResponseEntity<>("matched",HttpStatus.OK);
    }

    @GetMapping("/fetchMessages")
    public ResponseEntity<List<String>> fetch(@RequestParam("token")String token){
       List<String> messages = service.fetchMessages(token);
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }
}
