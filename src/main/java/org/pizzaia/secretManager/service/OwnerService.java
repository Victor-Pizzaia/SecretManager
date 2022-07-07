package org.pizzaia.secretManager.service;

import org.pizzaia.secretManager.model.Owner;
import org.pizzaia.secretManager.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Owner getOwnerByUsername(String username) {
        return ownerRepository.findByUsername(username);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer saveOrUpdateOwner(Owner owner) {
        owner.setPassword(encoder.encode(owner.getPassword()));
        return ownerRepository.save(owner).getId();
    }
}
