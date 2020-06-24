package jp.co.ntt.webapp.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class DummyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new User(username, "notUsed", true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
    }
}
