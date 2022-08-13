package org.pizzaia.secretManager.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.pizzaia.secretManager.model.GetSecretDTO;
import org.pizzaia.secretManager.model.Secret;
import org.pizzaia.secretManager.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/v1")
public class SecretController {

    @Autowired
    private SecretService secretService;

    @GetMapping("/secret")
    public ResponseEntity<String> getSecretByName(@RequestBody GetSecretDTO secretName, HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        Secret secret = secretService.getSecretByName(secretName.getSecretName(), username);
        return new ResponseEntity<>(secret.getValue(), HttpStatus.OK);
    }

    @PostMapping("/secret")
    public ResponseEntity<Void> saveOrUpdateSecret(@RequestBody Secret secret) {
        secretService.saveSecret(secret);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
