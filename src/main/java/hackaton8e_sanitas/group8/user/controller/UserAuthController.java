package hackaton8e_sanitas.group8.user.controller;

import hackaton8e_sanitas.group8.shared.responses.SuccessResponse;
import hackaton8e_sanitas.group8.user.dtos.login.LoginRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.login.LoginResponseDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterRequestDTO;
import hackaton8e_sanitas.group8.user.dtos.register.RegisterResponseDTO;
import hackaton8e_sanitas.group8.user.services.UserAuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-endpoint}/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse<RegisterResponseDTO>> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        RegisterResponseDTO registerResponse = userService.addUser(registerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessResponse.of("User registered successfully", registerResponse)
                );
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse<LoginResponseDTO>> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

        LoginResponseDTO loginResponse = userService.login(loginRequestDTO);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of("Login successful", loginResponse)
                );
    }

}
