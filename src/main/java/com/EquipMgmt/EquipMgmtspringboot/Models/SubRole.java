package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sub_roles")
public class SubRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "subRole", fetch = FetchType.EAGER )
    private Set<UserSubRoles> userSubRoles;

    public SubRole () {
    }

    public SubRole(Long id, String name, Role role, Set<UserSubRoles> userSubRoles) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.userSubRoles = userSubRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<UserSubRoles> getUserSubRoles() {
        return userSubRoles;
    }

    public void setUserSubRoles(Set<UserSubRoles> userSubRoles) {
        this.userSubRoles = userSubRoles;
    }
}