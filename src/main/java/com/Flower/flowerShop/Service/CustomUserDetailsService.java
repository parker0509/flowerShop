package com.Flower.flowerShop.Service;

import com.Flower.flowerShop.DAO.UserRepository;
import com.Flower.flowerShop.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByMemberEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을수 없습니다."));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getMemberEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}

