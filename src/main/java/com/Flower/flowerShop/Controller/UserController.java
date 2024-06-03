package com.Flower.flowerShop.Controller;

import com.Flower.flowerShop.DAO.UserRepository;
import com.Flower.flowerShop.DTO.UserRequestDto;
import com.Flower.flowerShop.Service.MemberService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.stream.events.Attribute;

@Controller
public class UserController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "parker");
        return "index";
    }

    /*  @GetMapping("/product")
      public String product(){
          return "product";
      }*/
    @GetMapping("/productCheck")
    public String product() {
        return "productCheck";
    }

    @GetMapping("/upload_Product_form")
    public String uploadProduct() {
        return "/upload_Product_form";
    }

    @GetMapping("/read_Product_form")
    public String readProduct() {
        return "/read_Product_form";
    }

    @GetMapping("readProductForm")
    public String readProductCheck() {
        return "/readProductForm";
    }

    @GetMapping("/join")
    public String joinUser() {
        return "/join";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("userRequestDto", new UserRequestDto());
        return "signup";
    }


    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("userRequestDto") UserRequestDto userRequestDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "signup";
        }

   /*     Long memberId = memberService.join(userRequestDto);
        model.addAttribute("memberId",memberId);*/

        return "redirect:/signup-success";
    }

    @GetMapping("/signup-success")
    public String signupSuccess(){
        return "signup-success";
    }

    /*@PostMapping("/signup")
    public String signup(@ModelAttribute("memberRequestDto") UserRequestDto memberRequestDto) {
        // 회원 가입 로직 수행
        memberService.join(memberRequestDto);

        // 회원 가입 성공 후 리다이렉트
        return "redirect:/signup-success";
    }*/

    @GetMapping("/login")
    public String showloginForm() {

        return "login";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }
}
