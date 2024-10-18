package org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user;

import org.noctisdev.sciallhexvsg.notifications.application.INotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return new UserDetailsImpl(null);
    }
}
