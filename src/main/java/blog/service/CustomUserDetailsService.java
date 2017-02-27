package blog.service;

import blog.domain.Role;
import blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userService.getUserByUsername(username);
        System.out.println("user = " + user.getUsername());
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    @Transactional(readOnly = true)
    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (!user.getRoles().isEmpty()) {
            for (Role role : user.getRoles()) {
                System.out.println("UserProfile : " + role.getType());
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
            }
        }
        if (user.getRoles().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
