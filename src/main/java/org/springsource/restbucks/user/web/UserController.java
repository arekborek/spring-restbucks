package org.springsource.restbucks.user.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springsource.restbucks.user.User;
import org.springsource.restbucks.user.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class UserController {

    private final @NotNull UserService userService;
    private final @NotNull UserLink userLink;

    @RequestMapping(path = "/", method = GET)
    HttpEntity<List<Resource<User>>> list() {

        List<Resource<User>> resource = userService.list()
                .map(user -> new Resource<>(user, userLink.self(user)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(resource);
    }

    @PreAuthorize("@_security_service.canAccessUser(principal, #userId)")
    @RequestMapping(path = "/{userId}", method = GET)
    public HttpEntity get(@PathVariable Long userId) {
        return userService.load(userId)
                .map(u -> new Resource(u, userLink.self(u)))
                .map(r -> (HttpEntity) ResponseEntity.ok(r))
                .orElse(ResponseEntity.notFound().build());
    }

}
