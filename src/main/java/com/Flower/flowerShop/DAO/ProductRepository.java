package com.Flower.flowerShop.DAO;

import com.Flower.flowerShop.DTO.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}




