package net.mcoto.app.services;

import net.mcoto.app.entities.AppUsers;
import net.mcoto.app.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CostumUserDetailsService implements UserDetailsService {

    final private AppUserRepository appUserRepository;

    public CostumUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUsers appUsers = appUserRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found or not exists"));
        return User.builder()
                .username(appUsers.getUserName())
                .password(appUsers.getPassword())
                .roles(appUsers.getRole())
                .build();
    }
}
