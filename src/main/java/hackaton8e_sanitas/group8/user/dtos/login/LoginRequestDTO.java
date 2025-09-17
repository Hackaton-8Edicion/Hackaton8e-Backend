package hackaton8e_sanitas.group8.user.dtos.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "Username or e-mail is required")
        String identifier,

        @NotBlank(message = "Password is required")
        String password
) {
}
