package hackaton8e_sanitas.group8.user.dtos.user;

import hackaton8e_sanitas.group8.user.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserRequestDTO dto) {
        if (dto == null) return null;
        return UserEntity.builder()
                .name(dto.name())
                .username(dto.username())
                .email(dto.email())
                .build();
    }

    public static UserRequestDTO toRequestDto(UserEntity entity) {
        if (entity == null) return null;
        return new UserRequestDTO(
                entity.getName(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getCardnumber()
        );
    }
}