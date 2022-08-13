package org.pizzaia.secretManager.service;

import org.pizzaia.secretManager.model.Owner;
import org.pizzaia.secretManager.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class OwnerService implements UserDetailsService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerRepository.findByUsername(username);
        if(owner == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(owner.getId().toString()));
        return new User(owner.getUsername(), owner.getPassword(), authorities);
    }

    public Owner getOwnerByUsername(String username) {
        return ownerRepository.findByUsername(username);
    }

    @Transactional(rollbackFor = Exception.class)
    public Owner saveOrUpdateOwner(Owner owner) {
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        return ownerRepository.save(owner);
    }
}
