package org.pizzaia.secretManager.controller;

import org.pizzaia.secretManager.model.Owner;
import org.pizzaia.secretManager.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner/{username}")
    public ResponseEntity<Owner> getByUsername(@PathVariable String username) {
        System.out.println("chegou aqui");
        return new ResponseEntity<>(ownerService.getOwnerByUsername(username), HttpStatus.OK);
    }
}
