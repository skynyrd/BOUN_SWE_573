package com.bounfoodcoop.controller;

import com.bounfoodcoop.domain.ProductDocument;
import com.bounfoodcoop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class HomeController {

    private ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String home(Model model){
        ProductDocument promotedProduct = productService.getPromotedProduct("Kars Gravyeri");
        model.addAttribute("promoted", promotedProduct);
        return "views/index";
    }

    @RequestMapping("/productList")
    public String getAllProducts(Model model){
        List<ProductDocument> allProducts = productService.getAllProducts();

        model.addAttribute("products", allProducts);
        return "views/productList";
    }

    @RequestMapping("/product/id/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        ProductDocument product = productService.getById(UUID.fromString(productId));
        model.addAttribute("product", product);
        return "views/productDetail";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "views/admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<ProductDocument> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "views/adminProductList";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        ProductDocument product = new ProductDocument();
        product.setCategory("Beyaz Et");
        product.setStatus("Aktif");

        model.addAttribute("product", product);

        return "views/addProduct";
    }
}
