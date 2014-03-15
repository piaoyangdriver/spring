package com.test.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.domain.Users;

@Service("hibernateUserDetailsService")
public class HibernateUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Users users = new Users();
		users.setUsername("admin");
		users.setPassword("admin");
		users.setRoles("ROLE_USER");
		
		/*if(user == null){
			throw new UsernameNotFoundException("用户" + username + " 不存在!!!");
		}*/
		
		String[] roles = users.getRoles().split(",");  
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();  
        
        for(String role : roles)
        {  
            authorities.add(new SimpleGrantedAuthority(role));  
        }
        return new User(users.getUsername(), users.getPassword(), authorities);
	}
}
