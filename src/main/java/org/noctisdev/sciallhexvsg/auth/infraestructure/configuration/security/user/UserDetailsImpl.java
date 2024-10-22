package org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user;

import lombok.AllArgsConstructor;
import org.noctisdev.sciallhexvsg.auth.domain.models.enums.UserStatus;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.ContactEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.CredentialEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.UserEntity;
import org.noctisdev.sciallhexvsg.auth.infraestructure.entities.enums.UserStatusEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final CredentialEntity credential;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.<GrantedAuthority>of(new SimpleGrantedAuthority("ROLE_DEFAULT"));
    }

    @Override
    public String getPassword() {
        return credential.getPassword();
    }

    @Override
    public String getUsername() {
        return credential.getContactEntity().getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return credential.getContactEntity()
                .getUserEntity()
                .getStatus()
                .equals(UserStatusEntity.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return credential.getVerifiedAt() != null;
    }

    public String getName() {
        return credential.getContactEntity().getEmail();
    }
}
