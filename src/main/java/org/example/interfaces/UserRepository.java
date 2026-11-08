package org.example.interfaces;

public interface UserRepository {
    boolean existsByEmail(String email);
    void save(String email);
}