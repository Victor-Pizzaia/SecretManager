package org.pizzaia.secretManager.service;

import org.pizzaia.secretManager.model.Owner;
import org.pizzaia.secretManager.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner getOwnerByUsername(String username) {
        return ownerRepository.findByUsername(username);
    }

    public void saveOrUpdateOwner(Owner owner) {
        // TODO - implements bcrypt
        ownerRepository.save(owner);
    }
}
