package hackaton8e_sanitas.group8.user.services;

import hackaton8e_sanitas.group8.security.userdetails.CustomUserDetails;
import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.dtos.login.LoginRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.login.LoginResponseDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterMapper;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterResponseDTO;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAuthServiceImpl implements UserAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public RegisterResponseDTO addUser(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByUsername(registerRequestDTO.username())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(registerRequestDTO.email())) {
            throw new RuntimeException("Email already registered");
        }

        UserEntity newUser = RegisterMapper.dtoToEntity(registerRequestDTO);
        newUser.setPassword(passwordEncoder.encode(registerRequestDTO.password()));
        UserEntity savedUser = userRepository.save(newUser);

        return RegisterMapper.entityToDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDTO.identifier(),
                            loginRequestDTO.password()
                    )
            );
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            return new LoginResponseDTO("Login correcto para el usuario:" + loginRequestDTO.identifier());

        } catch (UsernameNotFoundException exception) {
            throw new EntityNotFoundException("User not found: " + loginRequestDTO.identifier());
        } catch (BadCredentialsException exception) {
            throw new RuntimeException("Invalid credentials for: " + loginRequestDTO.identifier());
        }
    }
}
