package com.EquipMgmt.EquipMgmtspringboot.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.EquipMgmt.EquipMgmtspringboot.Models.UserSubRoles;
import com.EquipMgmt.EquipMgmtspringboot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.EquipMgmt.EquipMgmtspringboot.Models.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userService.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<UserSubRoles> subRoles = user.getUserSubRoles();

        for (UserSubRoles userSubRoles : subRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userSubRoles.getSubRoles().getName()));
        }

        return new CustomUserDetails(user, grantedAuthorities);
    }
}
