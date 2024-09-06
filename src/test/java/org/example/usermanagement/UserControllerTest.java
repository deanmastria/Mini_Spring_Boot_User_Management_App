package org.example.usermanagement;

import org.example.usermanagement.model.User;
import org.example.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void testRegisterUser() {
        MockitoAnnotations.openMocks(this);

        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("Password1");

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        ResponseEntity<?> response = userController.registerUser(user, result);

        assertEquals("User registered successfully", response.getBody());
    }
}
