package org.example.testtaskvk.repository;

import org.example.testtaskvk.models.AuntificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuntificationUserRepository extends JpaRepository<AuntificationUser, Long> {
    AuntificationUser findByUsername(String username);
}
