package com.example.authtemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity user = userRepository.findByUsername(username);
        LOGGER.info("Retrieved user: {}", user);
        LOGGER.info("Retrieved user role: {}", user.getRole());
        final CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }
}
