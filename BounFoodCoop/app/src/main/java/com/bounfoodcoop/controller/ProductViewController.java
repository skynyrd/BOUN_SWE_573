package com.bounfoodcoop.controller;

import com.bounfoodcoop.service.ProductService;
import domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import representation.ProductListRepresentation;
import representation.ProductRepresentation;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class ProductViewController {

    private ProductService productService;

    public ProductViewController(ProductService productService) {
        this.productService = productService;
    }

    //Homepage
    @RequestMapping("/")
    public String home(Model model){
        Product promotedProduct = productService.getPromotedProduct("Kars Gravyeri");
        model.addAttribute("promoted", new ProductRepresentation(promotedProduct));
        return "views/index";
    }

    @RequestMapping("/product/all")
    public String getAllProducts(Model model){
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", new ProductListRepresentation(allProducts));
        return "views/productList";
    }

    @RequestMapping("/product/id/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        Product product = productService.getById(UUID.fromString(productId));
        model.addAttribute("product", new ProductRepresentation(product));
        return "views/productDetail";
    }
}
