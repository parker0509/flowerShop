package com.Flower.flowerShop.Service;

import com.Flower.flowerShop.DAO.ProductRepository;
import com.Flower.flowerShop.DAO.UserRepository;
import com.Flower.flowerShop.DTO.User;
import com.Flower.flowerShop.DTO.UserRequestDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.Member;
import java.util.Optional;

@Service
@NoArgsConstructor
public class MemberServiceImpl implements MemberService{

    @Autowired
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Long join(UserRequestDto userRequestDto) {
        User user = new User();
        user.setNickname(userRequestDto.getNickname());
        user.setMemberEmail(userRequestDto.getMemberEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setAccountType(userRequestDto.getAccountType());

        User savedMember = userRepository.save(user);
        return savedMember.getId();
    }
}
