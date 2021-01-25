package com.checkmeal.controllers;

import com.checkmeal.domain.MealOrder;
import com.checkmeal.domain.MealTable;
import com.checkmeal.service.IMealOrderService;
import com.checkmeal.service.IMealTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  MealOrderController is the API Endpoint for ...example example
 *  example
 *
 * Endpoint: /orders
 *
 */
@RestController
@RequestMapping("/orders")
public class MealOrderController {

    @Autowired
    private IMealOrderService mealOrderService;

    /**
     * This method...example example example
     *
     * Endpoint: /orders/mealtable GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("mealtable")
    @ResponseBody
    public MealOrder getMealOrder(@RequestParam(required = true) String tableName) {
        return mealOrderService.findOpenOrderByMealTableName(tableName);
    }

    /**
     * This method...example example example
     *
     * Endpoint: /orders/new POST
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @PostMapping("new")
    public MealOrder createOrder(MealOrder order) {
        return mealOrderService.createOrder(order);
    }

    /**
     * This method...example example example
     *
     * Endpoint: /orders/{mealOrderId} PUT
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @PutMapping("{mealOrderId}")
    public MealOrder updateOrder(@PathVariable("mealOrderId") long mealOrderId, MealOrder order) {
        return mealOrderService.updateOrder(order);
    }

    /**
     * This method...example example example
     *
     * Endpoint: /orders/close/{mealOrderId} GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("close/{mealOrderId}")
    public MealOrder closeOrder(@PathVariable("mealOrderId") long mealOrderId) {
        return mealOrderService.closeOrder(mealOrderId);
    }

}
