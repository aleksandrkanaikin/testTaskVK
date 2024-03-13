package org.example.testtaskvk.service;

import org.apache.catalina.users.AbstractUser;
import org.example.testtaskvk.AuntificationUserDetails;
import org.example.testtaskvk.models.AuntificationUser;
import org.example.testtaskvk.repository.AuntificationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutintificationUserDetailService implements UserDetailsService {

    @Autowired
    private AuntificationUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<AuntificationUser> user = repository.findByName(name);
        return user.map(AuntificationUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(name + "Not Found"));
    }
}
