package com.drivers.manager.security;

import com.drivers.entity.SysManager;
import com.drivers.entity.User;
import com.drivers.router.repository.SysManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/19
 */
@Service("userDetailsService")
@Transactional
@Slf4j
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private SysManagerRepository sysManagerRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        log.debug("Authenticating {}", login);
//        Optional<User> userFromDatabase = Optional.ofNullable(sysManagerRepository.findUserWithAuthoritiesByLogin(login));
        Optional<SysManager> userFromDatabase = Optional.ofNullable(sysManagerRepository.findByUsername(login));

        return userFromDatabase.map(user -> {
//            if (!user.getActivated()){
//                throw new UserNotActivatedException("User " + login + " was not activated");
//            }
//            List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
//                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                    .collect(Collectors.toList());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            return new org.springframework.security.core.userdetails.User(login,
                    user.getPassword(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + login + " was not found in the " +
                "database"));
    }
}
