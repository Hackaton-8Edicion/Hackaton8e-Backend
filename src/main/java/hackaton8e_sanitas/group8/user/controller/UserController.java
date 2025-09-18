package hackaton8e_sanitas.group8.user.controller;
import hackaton8e_sanitas.group8.user.dtos.user.UserRequestDTO;
import hackaton8e_sanitas.group8.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api-endpoint}/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserRequestDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserRequestDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userDto) {
        return userService.updateUser(id, userDto);
    }
}