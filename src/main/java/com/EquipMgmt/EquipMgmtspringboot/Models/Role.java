package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<SubRole> subRoles;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER )
    private Set<UserRole> roleUsers;

    // No-Args Constructor
    public Role() {
    }

    public Role(Long id, String name, Set<SubRole> subRoles, Set<UserRole> roleUsers) {
        this.id = id;
        this.name = name;
        this.subRoles = subRoles;
        this.roleUsers = roleUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 3, max = 50) String name) {
        this.name = name;
    }

    public Set<SubRole> getSubRoles() {
        return subRoles;
    }

    public void setSubRoles(Set<SubRole> subRoles) {
        this.subRoles = subRoles;
    }

    public Set<UserRole> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<UserRole> roleUsers) {
        this.roleUsers = roleUsers;
    }
}
