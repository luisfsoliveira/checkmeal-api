package com.checkmeal.service;

import com.checkmeal.domain.MealOrder;

/**
 * Service that provides ...example example
 * example
 */
public interface IMealOrderService {

    /**
     * example example example
     * @return ...
     */
    public MealOrder findOpenOrderByMealTableName(String mealTableName);

    /**
     * example example example
     * @return ...
     */
    public MealOrder createOrder(MealOrder order);

    /**
     * example example example
     * @return ...
     */
    public MealOrder updateOrder(MealOrder order);

    /**
     * example example example
     * @return ...
     */
    public MealOrder closeOrder(long mealOrderId);

    /**
     * example example example
     * @return ...
     */
    public Long calculateOrderTime(MealOrder mealOrder);

}