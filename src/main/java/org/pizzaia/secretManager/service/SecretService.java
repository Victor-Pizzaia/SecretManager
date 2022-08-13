package org.pizzaia.secretManager.service;

import org.pizzaia.secretManager.model.Secret;
import org.pizzaia.secretManager.repository.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    @Autowired
    private SecretRepository secretRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Secret getSecretByName(String secretName, String owner) {
        return secretRepository.getSecretByNameAndOwnerUsername(secretName, owner);

    }

    public void saveSecret(Secret secret) {
        secretRepository.save(secret);
    }
}
