package com.checkmeal.repositories;

import com.checkmeal.domain.MealTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealTableRepository extends JpaRepository<MealTable, Long> {

    List<MealTable> findByTableName(String name);
}
