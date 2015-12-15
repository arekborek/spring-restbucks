package org.springsource.restbucks.user.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springsource.restbucks.user.User;
import org.springsource.restbucks.user.UserService;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/users")
@ExposesResourceFor(User.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserController {

    private final @NotNull UserService userService;
    private final @NotNull UserLink userLink;

    @RequestMapping(path = "/", method = GET)
    HttpEntity<List<Resource<User>>> list() {

        List<Resource<User>> resource = userService.list()
                .map(user -> {
                    Resource<User> userResource = new Resource<>(user);
                    userResource.add(userLink.self(user));
                    return userResource;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(resource);

    }

}
