package com.tukicoders.InventoryApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class CUser {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String email;

}
