package edu.miu.eshop.controller;

import edu.miu.eshop.model.Product;
import edu.miu.eshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"api/products"})
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {""})
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(value = {"/{id}"})
    public List<Product> getBySubId(@PathVariable long id) {
        return productService.getBySubCategoryId(id);
    }
}
