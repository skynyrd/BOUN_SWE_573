package com.bounfoodcoop.controller;

import com.bounfoodcoop.service.ProductService;
import domain.Product;
import domain.ProductCategory;
import domain.ProductStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import representation.ProductListRepresentation;
import representation.ProductRepresentation;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    private ProductService productService;

    public AdminViewController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("")
    public String adminPage(){
        return "views/admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", new ProductListRepresentation(products));
        return "views/adminProductList";
    }

    @RequestMapping("/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setCategory(ProductCategory.WHITE_MEAT);
        product.setStatus(ProductStatus.ACTIVE);

        model.addAttribute("product", new ProductRepresentation(product));

        return "views/addProduct";
    }

}
