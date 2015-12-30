package org.springsource.restbucks.security;

import org.springframework.stereotype.Service;
import org.springsource.restbucks.user.Role;

@Service("_security_service")
public class MethodSecurityService {

    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
