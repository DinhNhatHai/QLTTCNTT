package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "user_sub_roles")
public class UserSubRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "sub_role_id", referencedColumnName = "id", nullable = false)
    private SubRole subRole;

    public UserSubRoles() {
    }

    public UserSubRoles(Long id, User user, SubRole subRole) {
        this.id = id;
        this.user = user;
        this.subRole = subRole;
    }

    public SubRole getSubRole() {
        return subRole;
    }

    public void setSubRole(SubRole subRole) {
        this.subRole = subRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
