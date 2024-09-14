package com.example.demo.controllers;


import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BuyProductController {

    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;


    public BuyProductController(ProductRepository productRepository, ProductServiceImpl productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    //mapping for buy button task F
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theId, Model model) {
        Product product1 = productService.findById(theId);

        if (productService.decrementInv(product1)) {
            product1.setInv(product1.getInv() - 1);
            productService.save(product1);
            model.addAttribute("product", product1);

            return "buySuccess";
        } else {
            model.addAttribute("product", product1);

            return "outofstock";
        }
    }

}
