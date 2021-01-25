package com.checkmeal.service;

import com.checkmeal.domain.Dish;
import com.checkmeal.domain.Product;
import com.checkmeal.repositories.DishRepository;
import com.checkmeal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that provides ...example example
 * example
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DishRepository dishRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

}
