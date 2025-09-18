package hackaton8e_sanitas.group8.user.services;

import hackaton8e_sanitas.group8.user.dtos.user.UserRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.user.UserResponseDTO;

public interface UserService {
    UserRequestDTO getUserById(Long id);
    UserRequestDTO updateUser(Long id, UserRequestDTO userDto);
}