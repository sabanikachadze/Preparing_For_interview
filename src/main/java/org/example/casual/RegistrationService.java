package org.example.casual;

import org.example.interfaces.Mailer;
import org.example.interfaces.UserRepository;

public class RegistrationService {
    private final UserRepository repo;
    private final Mailer mailer;

    RegistrationService(UserRepository repo, Mailer mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    void register(String email) {
        if (repo.existsByEmail(email)) {
            throw new IllegalStateException("already registered");
        }
        repo.save(email);
        mailer.sendWelcome(email);
    }
}