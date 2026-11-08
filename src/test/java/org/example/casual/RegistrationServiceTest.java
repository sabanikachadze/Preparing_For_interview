package org.example.casual;

import org.example.interfaces.Mailer;
import org.example.interfaces.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private Mailer mailer;

    @Mock
    private UserRepository repo;

    @InjectMocks
    RegistrationService service;

    @Test
    public void register_stopsRegistration_whenEmailAlreadyExists() {
        when(repo.existsByEmail("a@mail.com")).thenReturn(true);
        assertThrows(IllegalStateException.class, () -> service.register("a@mail.com"));
        verify(repo, never()).save(any());
        verify(mailer, never()).sendWelcome(any());
    }


    @Test
    public void register_continuesRegistration_whenEmailDoesNotExist() {
        when(repo.existsByEmail("a@mail.com")).thenReturn(false);
        service.register("a@mail.com");
        verify(repo, times(1)).save("a@mail.com");
        verify(mailer, times(1)).sendWelcome("a@mail.com");
    }
}