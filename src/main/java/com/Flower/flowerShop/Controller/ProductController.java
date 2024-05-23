package com.Flower.flowerShop.Controller;

import com.Flower.flowerShop.DAO.ProductRepository;
import com.Flower.flowerShop.DTO.Product;
import com.Flower.flowerShop.Service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.UUID;


@Controller
public class ProductController {

    //@ 필수 애노테이션의 쓰임과 사용 방법 그리고 외우기
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @RequestMapping("/uploadProductForm")
    public String uploadProductForm() {
        return "upload_Product_form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product, @RequestParam("imageFile") MultipartFile imageFile) throws Exception {
        if (!imageFile.isEmpty()) {
            // 프로젝트 내의 uploads 디렉토리에 파일 저장
            String uploadDir = "/src/main/resources/static/files/"; // 파일이 저장될 경로 설정
            String fileName = "";

            // 프로젝트 경로에 디렉토리가 존재하는지 확인하고 없으면 생성
            String projectPath = System.getProperty("user.dir") + uploadDir;
            File uploadPath = new File(projectPath);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            // 파일 이름 설정
            UUID uuid = UUID.randomUUID();
            String savedFileName = uuid + "_" + imageFile.getOriginalFilename();
            fileName = savedFileName;

            // 파일 저장
            File saveFile = new File(uploadPath, fileName);
            imageFile.transferTo(saveFile);

            // 제품 엔티티에 이미지 정보 설정
            product.setImageName(fileName);
            product.setImageUrl("/files/" + fileName);

            // 제품 엔티티 저장
            productRepository.save(product);
        }
        return "redirect:/uploadProductForm?success";
    }

    /*  Path uploadPath = Paths.get(uploadDir);
         if (!Files.exists(uploadPath)) {
             Files.createDirectories(uploadPath);
         }
         Path filePath = uploadPath.resolve(fileName);
         imageFile.transferTo(filePath.toFile());
         String imageUrl = "uploads/" + fileName;; // 이미지 URL 설정
         product.setImageUrl(imageUrl);
         product.setImageName(fileName); // 파일 이름 저장
     } catch (IOException e) {
         e.printStackTrace();
         return "redirect:/uploadProductForm?error";
     }*/
    @PostMapping("/readProduct")
    public String readProduct(Product product) {
        productRepository.findAll();
        return "redirect:/readProductForm";
    }

    @GetMapping("/readProduct/{id}")
    public Optional<Product> readProductByid(@PathVariable Long id) {
        return productRepository.findById(id);

    }
    @GetMapping("/productList")
    public String productList(Model model){
        List<Product>product = productRepository.findAll();
        model.addAttribute("products",product);
        return "productList";
    }

    //상품의 세부 사항 체크
    @GetMapping("/productDetailCheck")
    public String productDetailCheck(@RequestParam(name = "productId", required = false, defaultValue = "0") Long productId, Model model) {

        if (productId == 0) {
            model.addAttribute("productDetails", "Product ID is missing or NOT FIND");
            return "productDetailCheck";
        }


            Product product = productService.getProductDetail(productId);


        //왜 attributName의 메소드만적었을때는 왜 안됐지?
        // attributeName 에 대해서 기술
        if (product != null) {
            model.addAttribute("productName", product.getProductName());
            model.addAttribute("productPrice", product.getProductPrice());
            model.addAttribute("productId", product.getId());
        } else {
            model.addAttribute("productDetails", "Product NOT FOUND");
        }
            return "productDetailCheck";
        }


    }
