package org.springsource.restbucks.user;

import java.util.stream.Stream;

public interface UserService {

    Stream<User> list();

}
