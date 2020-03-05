package com.neofect.gts.web.cms.security;

import com.unvus.domain.Authority;
import com.neofect.gts.core.services.user.domain.UserAccount;
import com.neofect.gts.core.services.user.domain.enums.AccountType;
import com.neofect.gts.core.services.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserService userService;

    public DomainUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        UserAccount userAccount = userService.getUserAccountForLogin(lowercaseLogin, AccountType.ADMIN);

        if(userAccount == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }

        if(userAccount.getDeleted() || !userAccount.isEnabled()) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        }

        buildAuthorities(userAccount);

        return userAccount;
    }

    private void buildAuthorities(UserAccount userAccount) {
        if(userAccount == null) {
            return;
        }
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority("ROLE_CMS"));
//        try {
//            List<String> authList = (List<String>)mapper.readValue(user.getAuthority(), List.class);
//            for(String auth : authList) {
//                authorities.add(new Authority(auth));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        authorities.add(new Authority("ROLE_CMS"));
        userAccount.setAuthorities(authorities);
    }

}
