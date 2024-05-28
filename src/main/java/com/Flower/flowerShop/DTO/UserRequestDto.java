package com.Flower.flowerShop.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import io.swagger.annotations.ApiModel; // Swagger @ApiModel 어노테이션 import
import io.swagger.annotations.ApiModelProperty; // Swagger @ApiModelProperty 어노테이션 import
import lombok.Setter;


@NoArgsConstructor
@Data
@Getter
@Setter
@ApiModel(description = "회원 요청을 위한 데이터 전송 객체") // 클래스 설명 추가
public class UserRequestDto {

    @NotBlank(message = "닉네임을 적어 주세요.  비워 둘 수 없습니다.")
    @ApiModelProperty(value = "회원의 닉네임" , required = true)
    public String nickname;

    @NotBlank(message = "이메일을 입력 해주세요. 비워 둘 수 없습니다.")
    @ApiModelProperty(value = "회원의 이메일" , required = true)
    public String memberEmail;

    @NotBlank(message = "패스워드를 입력 해주세요. 비워 둘 수 없습니다.")
    @ApiModelProperty(value = "회원의 비밀번호" , required = true)
    @Pattern(


            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 최소 8자 이상, 하나의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자를 포함해야 합니다."
            /*
            정규표현식

            ^ : 문자열의 시작을 의미합니다.
            (?=.*[A-Z]) : 적어도 하나의 대문자를 포함해야 함을 의미합니다.
            (?=.*[a-z]) : 적어도 하나의 소문자를 포함해야 함을 의미합니다.
            (?=.*\\d) : 적어도 하나의 숫자를 포함해야 함을 의미합니다.
            (?=.*[@$!%*?&]) : 적어도 하나의 특수 문자를 포함해야 함을 의미합니다.
            [A-Za-z\\d@$!%*?&]{8,} : 위의 조건을 만족하는 8자 이상의 문자열이어야 함을 의미합니다.
            $ : 문자열의 끝을 의미합니다.*/

    )
    public String password;

    @NotBlank(message = "계정 유형을 입력 해주세요. 비워 둘 수 없습니다.")
    @ApiModelProperty(value = "회원의 이메일" , required = true)
    public String accountType;


}
