package org.springsource.restbucks.user.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springsource.restbucks.user.User;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserLink {

    private final @NonNull EntityLinks entityLinks;

    Link self(User user) {
        return entityLinks.linkForSingleResource(user).withSelfRel();
    }

}
