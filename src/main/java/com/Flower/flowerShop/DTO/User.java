package com.Flower.flowerShop.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ID
    private Long id;
    //NICKNAME
    private String nickname;
    //EMAIL
    private String memberEmail;
    //PASSWORD
    private String password;
    //AccountType:타입유형 (example=구글)
    private String accountType;
}
