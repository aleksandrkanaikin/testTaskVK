package org.example.testtaskvk.repository;

import org.example.testtaskvk.models.AuntificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuntificationUserRepository extends JpaRepository<AuntificationUser, Long> {
    Optional<AuntificationUser> findByName(String name);
}
