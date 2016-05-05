package com.bounfoodcoop.controller;

import com.bounfoodcoop.domain.ProductCategory;
import com.bounfoodcoop.domain.Product;
import com.bounfoodcoop.domain.ProductStatus;
import com.bounfoodcoop.domain.representation.ProductListRepresentation;
import com.bounfoodcoop.domain.representation.ProductRepresentation;
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
        Product promotedProduct = productService.getPromotedProduct("Kars Gravyeri");
        model.addAttribute("promoted", new ProductRepresentation(promotedProduct));
        return "views/index";
    }

    @RequestMapping("/productList")
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

    @RequestMapping("/admin")
    public String adminPage(){
        return "views/admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", new ProductListRepresentation(products));
        return "views/adminProductList";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setCategory(ProductCategory.WHITE_MEAT);
        product.setStatus(ProductStatus.ACTIVE);

        model.addAttribute("product", new ProductRepresentation(product));

        return "views/addProduct";
    }
}
