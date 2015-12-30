package org.springsource.restbucks.security;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springsource.restbucks.user.Role;
import org.springsource.restbucks.user.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@ToString
public class CurrentUser implements UserDetails {

    private final @NonNull Long id;
    private final @NonNull String login;
    private final @NonNull String password;
    private final @NonNull Role role;
    private final @NonNull Collection<? extends GrantedAuthority> authorities;

    public CurrentUser(@NotNull User user) {
        id = user.getId();
        login = user.getLogin();
        password = user.getPassword();
        role = user.getRole();
        authorities = AuthorityUtils.createAuthorityList(user.getRole().toString());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
