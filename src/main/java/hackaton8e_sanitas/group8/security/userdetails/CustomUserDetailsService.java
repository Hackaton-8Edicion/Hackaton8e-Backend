package hackaton8e_sanitas.group8.security.userdetails;

import hackaton8e_sanitas.group8.user.UserEntity;
import hackaton8e_sanitas.group8.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {

        Optional<UserEntity> user = userRepository.findByUsername(identifier);

        if (user.isEmpty()) {
            user = userRepository.findByEmail(identifier);
        }

        return user.map(userEntity -> new CustomUserDetails(userEntity))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + identifier));
    }
}
