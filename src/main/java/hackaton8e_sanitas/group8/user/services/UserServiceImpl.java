package hackaton8e_sanitas.group8.user.services;

import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.dtos.user.UserRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.user.UserMapper;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserRequestDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return UserMapper.toRequestDto(user);
    }

    @Override
    public UserRequestDTO updateUser(Long id, UserRequestDTO userDto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setName(userDto.name());
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
     

        UserEntity updatedUser = userRepository.save(user);
        return UserMapper.toRequestDto(updatedUser);
    }
}