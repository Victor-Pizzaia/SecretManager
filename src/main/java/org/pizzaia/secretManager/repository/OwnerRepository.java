package org.pizzaia.secretManager.repository;

import org.pizzaia.secretManager.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findByUsername(String username);
}
