package com.app.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.demo.security.userRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class MyUserDetails implements UserDetails {

    private String username;

    public userRepository getUserRepository(userRepository user) {
        return user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() { 
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public String getPassword() {
        return "pass";
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
