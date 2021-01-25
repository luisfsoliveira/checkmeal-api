package com.checkmeal.service;

import com.checkmeal.domain.Dish;
import com.checkmeal.domain.MealOrder;
import com.checkmeal.domain.MealOrderLine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MealOrderServiceUnitTest {

    @Spy
    private MealOrderServiceImpl mealOrderService;

    @Mock
    private MealOrder mealOrder;

    @Test
    public void calculatingOrderTime_whenMealOrderIsNull_ThenNull() {
        Assert.assertNull(mealOrderService.calculateOrderTime(null));
    }

    @Test
    public void calculatingOrderTime_whenMealOrderLinesIsNull_ThenNull() {
        when(mealOrder.getOrderLines()).thenReturn(null);
        Assert.assertNull(mealOrderService.calculateOrderTime(mealOrder));
    }

    @Test
    public void calculatingOrderTime_whenMealOrderLinesIsEmpty_ThenNull() {
        when(mealOrder.getOrderLines()).thenReturn(new ArrayList<MealOrderLine>());
        Assert.assertNull(mealOrderService.calculateOrderTime(mealOrder));
    }

    @Test
    public void calculatingOrderTime_whenMealOrderLinesHasDishes_ThenMax() {
        MealOrderLine mealOrderLine1 = mock(MealOrderLine.class);
        MealOrderLine mealOrderLine2 = mock(MealOrderLine.class);
        MealOrderLine mealOrderLine3 = mock(MealOrderLine.class);
        Dish dish1 = mock(Dish.class);
        Dish dish2 = mock(Dish.class);
        Dish dish3 = mock(Dish.class);
        when(mealOrderLine1.getProduct()).thenReturn(dish1);
        when(mealOrderLine2.getProduct()).thenReturn(dish2);
        when(mealOrderLine3.getProduct()).thenReturn(dish3);
        when(dish1.getTimePrep()).thenReturn(new Long(3L));
        when(dish2.getTimePrep()).thenReturn(new Long(5L));
        when(dish3.getTimePrep()).thenReturn(new Long(2L));

        ArrayList<MealOrderLine> mealOrderLines = new ArrayList<MealOrderLine>() {
            {
                add(mealOrderLine1);
                add(mealOrderLine2);
                add(mealOrderLine3);
            }
        };

        when(mealOrder.getOrderLines()).thenReturn(mealOrderLines);
        Assert.assertEquals(new Long(5L), mealOrderService.calculateOrderTime(mealOrder));
    }

}
