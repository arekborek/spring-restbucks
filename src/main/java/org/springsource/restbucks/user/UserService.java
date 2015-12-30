package org.springsource.restbucks.user;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    Stream<User> list();

    Optional<User> load(Long userId);

}
