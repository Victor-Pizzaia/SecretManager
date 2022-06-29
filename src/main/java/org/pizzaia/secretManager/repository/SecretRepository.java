package org.pizzaia.secretManager.repository;

import org.pizzaia.secretManager.model.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Integer> {
}
