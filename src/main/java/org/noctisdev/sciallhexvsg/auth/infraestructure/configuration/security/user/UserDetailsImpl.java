package org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user;

import lombok.AllArgsConstructor;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.<GrantedAuthority>of(new SimpleGrantedAuthority("ROLE_DEFAULT"));
    }

    @Override
    public String getPassword() {
        return userEntity.getCredentialEntity().getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getContactEntity().getEmail();
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
        return userEntity.getCredentialEntity().getVerifiedAt() != null;
    }

    public String getName() {
        return userEntity.getContactEntity().getPhoneNumber();
    }
}
