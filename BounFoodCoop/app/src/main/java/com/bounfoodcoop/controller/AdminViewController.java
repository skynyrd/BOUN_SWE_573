package com.bounfoodcoop.controller;

import com.bounfoodcoop.service.ProductService;
import domain.Product;
import domain.ProductCategory;
import domain.ProductStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import representation.ProductListRepresentation;
import representation.ProductRepresentation;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model){
        model.addAttribute("product", new ProductRepresentation());

        return "views/addProduct";
    }
    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute ProductRepresentation product, Model model){

        model.addAttribute("product", product);

        return "views/addProduct";
    }

}
