package com.Flower.flowerShop.Service;

import com.Flower.flowerShop.DTO.User;
import com.Flower.flowerShop.DTO.UserRequestDto;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Member;


public interface MemberService {


    /**
     * [회원가입]
     * 회원정보를 입력받아 회원가입
     * @param userRequestDto 회원 엔티티 모델(id=null)
     * @return 성공 시 회원 PK 반환
     */

    public abstract Long join(UserRequestDto userRequestDto );

}
