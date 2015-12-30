package org.springsource.restbucks.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl  implements UserService {

    private final @NotNull UserRepository userRepository;

    @Override
    public Stream<User> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false);
    }

    @Override
    public Optional<User> load(Long userId) {
        return Optional.ofNullable(userRepository.findOne(userId));
    }
}
