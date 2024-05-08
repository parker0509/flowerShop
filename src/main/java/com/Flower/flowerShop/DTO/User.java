package com.Flower.flowerShop.DTO;

import jakarta.persistence.Entity;
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
    private Long id;

    private String name;
    private int Number;
    private int goodsNumber;

}
