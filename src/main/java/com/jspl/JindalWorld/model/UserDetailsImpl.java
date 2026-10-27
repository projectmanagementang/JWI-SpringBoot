package com.jspl.JindalWorld.model;

import com.jspl.JindalWorld.entity.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;



public class UserDetailsImpl implements UserDetails {

    private final UserAccount userAccount;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(
            UserAccount userAccount,
            Collection<? extends GrantedAuthority> authorities) {
        this.userAccount = userAccount;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getEmail();
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
