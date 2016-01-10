package org.springsource.restbucks.security;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsource.restbucks.user.Role;

@Service("securityService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MethodSecurityService {

    private final @NonNull LoggedUserGetter loggedUserGetter;

    public boolean canAccessUser(Long userId) {
        CurrentUser currentUser = loggedUserGetter.getLoggedUserDetails();
        return currentUser != null && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
