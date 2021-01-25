package com.checkmeal.controllers;

import com.checkmeal.domain.Dish;
import com.checkmeal.domain.MealTable;
import com.checkmeal.domain.Product;
import com.checkmeal.service.IMealTableService;
import com.checkmeal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  ProductController is the API Endpoint for ...example example
 *  example
 *
 * Endpoint: /products
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * This method...example example example
     *
     * Endpoint: /products/all GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("all")
    @ResponseBody
    public Collection<Product> getProducts() {
        return productService.findAll();
    }

    /**
     * This method...example example example
     *
     * Endpoint: /products/dishes GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("dishes")
    @ResponseBody
    public Collection<Dish> getDishes() {
        return productService.findAllDishes();
    }
}
