package com.rezende.learn.dto;

import com.rezende.learn.entities.Role;

import java.util.UUID;

public class RoleDTO {

    private UUID id;
    private String authority;

    public RoleDTO() {}

    public RoleDTO(UUID id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role entity) {
        setId(entity.getId());
        setAuthority(entity.getAuthority());
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}