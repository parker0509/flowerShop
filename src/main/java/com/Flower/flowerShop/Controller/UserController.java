package com.Flower.flowerShop.Controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name","parker");
        return "index";
    }
  /*  @GetMapping("/product")
    public String product(){
        return "product";
    }*/
    @GetMapping("/productCheck")
    public String product(){
        return "productCheck";
    }

    @GetMapping("/upload_Product_form")
    public String uploadProduct(){
        return "/upload_Product_form";
    }

    @GetMapping("/read_Product_form")
    public String readProduct(){
        return "/read_Product_form";
    }

    @GetMapping("readProductForm")
    public String readProductCheck(){
        return "/readProductForm";
    }

    @GetMapping("/join")
    public String joinUser(){return "/join"; }

    @GetMapping("/signup")
    public String joinHome(){return"/signup";}


}
