package com.dung2_backend.secure;

import com.dung2_backend.entity.User;
import com.dung2_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        List<User> users= (List<User>) userRepository.findByAccount(account);
        if(users.size()==0){
            throw new UsernameNotFoundException(account);
        }
        User user = users.get(0);
        List<GrantedAuthority> grandList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        grandList.add(authority);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getAccount(),user.getPassword(),grandList);
        return userDetails;
    }
}
