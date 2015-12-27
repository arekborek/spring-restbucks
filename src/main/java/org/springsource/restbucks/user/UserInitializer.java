package org.springsource.restbucks.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
@Slf4j
public class UserInitializer {

    @Autowired
    public UserInitializer(UserRepository repository) {
        asList(
                User.builder().login("luke_skywalker").password("insecure1").role(Role.USER).build(),
                User.builder().login("james_bond").password("insecure2").role(Role.ADMIN).build()
        ).forEach(user -> log.info("User {} created", repository.save(user)));
    }

}
