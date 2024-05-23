package com.Flower.flowerShop.Service;

import com.Flower.flowerShop.DAO.ProductRepository;
import com.Flower.flowerShop.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Product의 클래스를 가지고 와서 실행 필요
    public Product getProductDetail(Long productId){

        return productRepository.findById(productId).orElse(null);
    }
}
