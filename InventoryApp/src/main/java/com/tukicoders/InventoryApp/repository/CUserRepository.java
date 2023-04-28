package com.tukicoders.InventoryApp.repository;

import com.tukicoders.InventoryApp.model.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CUserRepository extends JpaRepository<CUser, Long> {
}
