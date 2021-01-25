package com.checkmeal.service;

import com.checkmeal.datacreator.OrderStatus;
import com.checkmeal.domain.Dish;
import com.checkmeal.domain.MealOrder;
import com.checkmeal.repositories.MealOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealOrderServiceImpl implements IMealOrderService {

    @Autowired
    MealOrderRepository mealOrderRepository;

    public MealOrder findOpenOrderByMealTableName(String mealTableName) {
        return mealOrderRepository.findFirstByStatusAndMealTableName(mealTableName, OrderStatus.OPEN.status);
    }

    public MealOrder createOrder(MealOrder order) {
        return mealOrderRepository.save(order);
    }

    public MealOrder updateOrder(MealOrder order) {
        return mealOrderRepository.save(order);
    }

    public MealOrder closeOrder(long mealOrderId) {
        MealOrder mo = mealOrderRepository.getOne(mealOrderId);
        if (mo != null) {
            mo.setStatus(OrderStatus.CLOSED);
        }
        return mo;
    }

    public Long calculateOrderTime(MealOrder mealOrder) {
        Optional<Long> orderTime = Optional.empty();
        if (mealOrder != null && mealOrder.getOrderLines() != null) {
            orderTime = mealOrder
                    .getOrderLines()
                    .stream()
                    .filter(p -> p.getProduct() instanceof Dish)
                    .map(t -> ((Dish) t.getProduct()).getTimePrep())
                    .max(Long::compare);
        }
        return orderTime.isPresent() ? orderTime.get() : null;
    }

}
