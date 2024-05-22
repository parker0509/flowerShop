package com.Flower.flowerShop.Controller;

import com.Flower.flowerShop.DAO.ProductRepository;
import com.Flower.flowerShop.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/uploadProductForm")
    public String uploadProductForm(){
        return "upload_Product_form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/uploadProductForm";
    }

    @PostMapping("/readProduct")
    public String readProduct(Product product){
        productRepository.findAll();
        return "redirect:/readProductForm";
    }
    @GetMapping("/readProduct/{id}")
    public Optional<Product> readProductByid(@PathVariable Long id){
        return productRepository.findById(id);

    }



}
