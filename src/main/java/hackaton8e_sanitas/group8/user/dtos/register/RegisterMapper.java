package hackaton8e_sanitas.group8.user.dtos.register;

import hackaton8e_sanitas.group8.user.UserEntity;

public class RegisterMapper {
    public static UserEntity dtoToEntity(RegisterRequestDTO registerRequestDTO) {
        return UserEntity.builder()
                .name(registerRequestDTO.name())
                .username(registerRequestDTO.username())
                .email(registerRequestDTO.email())
                .password(registerRequestDTO.password())
                .build();
    }
    public static RegisterResponseDTO entityToDto(UserEntity userEntity){
        return new RegisterResponseDTO(
                userEntity.getUsername(),
                userEntity.getEmail()
        );
    }
}
