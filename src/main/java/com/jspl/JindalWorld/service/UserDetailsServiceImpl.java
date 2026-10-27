package com.jspl.JindalWorld.service;

import com.jspl.JindalWorld.entity.Role;
import com.jspl.JindalWorld.entity.UserAccount;
import com.jspl.JindalWorld.entity.UserRole;
import com.jspl.JindalWorld.model.UserDetailsImpl;
import com.jspl.JindalWorld.repository.RoleRepository;
import com.jspl.JindalWorld.repository.UserAccountRepository;
import com.jspl.JindalWorld.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAccount user = userAccountRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found: " + username));

        List<UserRole> userRoles =
                userRoleRepository.findByUserId(user.getId());

        List<Long> roleIds = userRoles.stream()
                .map(UserRole::getRoleId)
                .toList();

        List<Role> roles = roleRepository.findAllById(roleIds);

        List<GrantedAuthority> authorities = roles.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .map(authority -> (GrantedAuthority) authority)
                .toList();

        return new UserDetailsImpl(user, authorities);
    }
}

