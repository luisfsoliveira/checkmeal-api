package com.checkmeal.repositories;

import com.checkmeal.domain.MealOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MealOrderRepository extends JpaRepository<MealOrder, Long> {

    @Query("FROM MealOrder as mo WHERE mo.mealTable.tableName = ?1 AND mo.status=?2")
    public MealOrder findFirstByStatusAndMealTableName(String mealTableName, Integer status);

}
