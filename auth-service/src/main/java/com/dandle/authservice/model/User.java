package com.dandle.authservice.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;


public class User {
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    private Set<String> roles;

    public User() {}

    public User(String email, String password, String name, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public Set<String> getRoles() { return this.roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", name=" + name + ", roles=" + roles + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User))
            return false;
        User user = (User) obj;
        return user.getEmail().equals(this.email) 
            && user.getName().equals(this.name) 
            && user.getPassword().equals(this.password) 
            && user.getRoles().equals(this.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name, roles);
    }
}
