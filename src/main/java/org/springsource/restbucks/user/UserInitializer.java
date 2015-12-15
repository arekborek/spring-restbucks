package org.springsource.restbucks.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInitializer {

    @Autowired
    public UserInitializer(UserRepository repository) {
        log.info("User {} created", repository.save(new User("luke_skywalker")));
        log.info("User {} created", repository.save(new User("james_bond")));
    }

}
