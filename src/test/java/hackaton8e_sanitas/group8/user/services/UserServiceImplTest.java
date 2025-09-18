
package hackaton8e_sanitas.group8.user.services;

import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.dtos.user.UserRequestDTO;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity user;
    private UserRequestDTO userRequestDTO;

    @BeforeEach
    void setUp() {
        user = new UserEntity();
        user.setId(1L);
        user.setName("Test User");
        user.setUsername("testuser");
        user.setEmail("test@user.com");
        user.setCardnumber("1234-5678-9012-3456");

        userRequestDTO = new UserRequestDTO("Test User", "testuser", "test@user.com", "1234-5678-9012-3456");
    }

    @Test
    void getUserById_shouldReturnUser_whenUserExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserRequestDTO foundUser = userService.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals(user.getName(), foundUser.name());
    }

    @Test
    void getUserById_shouldThrowException_whenUserDoesNotExist() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            userService.getUserById(1L);
        });
    }

    @Test
    void updateUser_shouldUpdateUser_whenUserExists() {
        UserRequestDTO updatedDto = new UserRequestDTO("Updated User", "updateduser", "updated@user.com", "1111-2222-3333-4444");
        UserEntity updatedUser = new UserEntity();
        updatedUser.setId(1L);
        updatedUser.setName(updatedDto.name());
        updatedUser.setUsername(updatedDto.username());
        updatedUser.setEmail(updatedDto.email());
        updatedUser.setCardnumber(updatedDto.cardnumber());


        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(UserEntity.class))).thenReturn(updatedUser);

        UserRequestDTO result = userService.updateUser(1L, updatedDto);

        assertNotNull(result);
        assertEquals(updatedDto.name(), result.name());
        assertEquals(updatedDto.username(), result.username());
    }

    @Test
    void updateUser_shouldThrowException_whenUserDoesNotExist() {
        UserRequestDTO updatedDto = new UserRequestDTO("Updated User", "updateduser", "updated@user.com", "1111-2222-3333-4444");
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            userService.updateUser(1L, updatedDto);
        });
    }
}
