package com.dandle.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dandle.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by username.
     * @param username the username of the user.
     * @return the user with the given username.
     * @since 1.0.0
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by email.
     * @param email the email of the user.
     * @return the user with the given email.
     * @since 1.0.0
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks if a user with the given username exists.
     * @param username the username of the user.
     * @return true if a user with the given username exists, false otherwise.
     * @since 1.0.0
     */
    Boolean existsByUsername(String username);

    /**
     * Checks if a user with the given email exists.
     * @param email the email of the user.
     * @return true if a user with the given email exists, false otherwise.
     * @since 1.0.0
     */
    Boolean existsByEmail(String email);
}
