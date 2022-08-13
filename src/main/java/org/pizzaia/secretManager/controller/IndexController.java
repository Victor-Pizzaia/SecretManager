package org.pizzaia.secretManager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Welcome to security manager WhereIsMyPassword", HttpStatus.OK);
    }
}
