package com.checkmeal.repositories;

import com.checkmeal.domain.MealOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealOrderLineRepository extends JpaRepository<MealOrderLine, Long> {
}
