package com.bounfoodcoop.controller;

import com.bounfoodcoop.service.ProductService;
import com.bounfoodcoop.core.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bounfoodcoop.core.representation.ProductListRepresentation;
import com.bounfoodcoop.core.representation.ProductRepresentation;

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

        productService.addProduct(product);

        return "redirect:/admin/productInventory/";
    }

    @RequestMapping(value = "/productInventory/deleteProduct/id/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable UUID productId){

        productService.deleteProduct(productId);

        return "redirect:/admin/productInventory/";
    }
}
