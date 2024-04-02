package com.example.storage.repositories;

import com.example.storage.entities.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Supply getSupplyByNameAndUsernameIsNull(String name);
    Integer countAllByNameAndUsernameIsNull(String name);
}
