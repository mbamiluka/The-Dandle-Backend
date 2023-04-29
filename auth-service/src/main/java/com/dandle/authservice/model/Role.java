package com.dandle.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import com.dandle.authservice.repository.RoleRepository;

//import com.dandle.authservice.repository.RoleRepository;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // this field is not used in the code, but it is used in the database. It is used to identify the role in the database.

    @Column(nullable = false, unique = true)
    private String roleName;

    private RoleRepository roleRepository; // roleRepository is used to access the database.

    public Role(@Nonnull RoleName roleName) {
        /**
         * Creates a new role.
         * @param roleName the name of the role.
         * @throws NullPointerException if roleName is null.
         * @since 1.0.0
         */
        Objects.requireNonNull(roleName);
        this.roleName = roleName.name();
    }

    @Override
    public String getAuthority() {
        /**
         * Gets the name of the role.
         * @return the name of the role.
         * @since 1.0.0
         */
        return roleName;
    }


    public Optional<Role> findByName(@Nonnull RoleName roleName) {
        /**
         * Finds a role by its name.
         * @param roleName the name of the role to find.
         * @return an optional containing the role if found, empty otherwise.
         * @throws NullPointerException if roleName is null.
         * @since 1.0.0
         */
        Objects.requireNonNull(roleName);
        return roleRepository.findByName(roleName);
    }


    public boolean isPresent(@Nonnull RoleName roleName) {
        /**
         * Checks if a role is present in the database.
         * @param roleName the name of the role to check.
         * @return true if the role is present, false otherwise.
         * @throws NullPointerException if roleName is null.
         * @since 1.0.0
         */
        Objects.requireNonNull(roleName);
        return findByName(roleName).isPresent();
    }

    @Override
    public String toString() {
        /**
         * Returns a string representation of the role.
         * @return a string representation of the role.
         * @since 1.0.0
         */
        return "Role [id=" + id + ", roleName=" + roleName + "]";
    }

    @Override
    public boolean equals(Object obj) {
        /**
         * Checks if the role is equal to another object.
         * @param obj the object to check.
         * @return true if the role is equal to the object, false otherwise.
         * @since 1.0.0
         */
        if (obj == this)
            return true;
        if (!(obj instanceof Role))
            return false;
        Role role = (Role) obj;
        return Objects.equals(id, role.id) && Objects.equals(roleName, role.roleName);
    }
}
