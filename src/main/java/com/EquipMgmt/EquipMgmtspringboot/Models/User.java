package com.EquipMgmt.EquipMgmtspringboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String userName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @NotNull
    @Size(min = 6, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Column(name = "enable", nullable = false)
    private boolean enable;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER )
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER )
    private Set<UserSubRoles> userSubRoles;


    public User() {
    }

    public User(Long id, String userName, String name, String password, String email, boolean enable, Employee employee, EmployeeType employeeType, Set<UserRole> userRoles, Set<UserSubRoles> userSubRoles) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.email = email;
        this.enable = enable;
        this.employee = employee;
        this.employeeType = employeeType;
        this.userRoles = userRoles;
        this.userSubRoles = userSubRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 50) String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull @Size(min = 3, max = 50) String userName) {
        this.userName = userName;
    }

    public @NotNull @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 3, max = 50) String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 6, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 6, max = 100) String password) {
        this.password = password;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    @NotNull
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(@NotNull boolean enable) {
        this.enable = enable;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<UserSubRoles> getUserSubRoles() {
        return userSubRoles;
    }

    public void setUserSubRoles(Set<UserSubRoles> userSubRoles) {
        this.userSubRoles = userSubRoles;
    }
}
