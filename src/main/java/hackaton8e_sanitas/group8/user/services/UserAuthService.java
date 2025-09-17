package hackaton8e_sanitas.group8.user.services;

import hackaton8e_sanitas.group8.user.dtos.login.LoginRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.login.LoginResponseDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterResponseDTO;

public interface UserAuthService {
    RegisterResponseDTO addUser(RegisterRequestDTO registerRequestDTO);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
