package com.checkmeal.service;

import com.checkmeal.domain.MealTable;
import com.checkmeal.repositories.MealTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealTableServiceImpl implements IMealTableService {

    @Autowired
    MealTableRepository mealTableRepository;

    public List<MealTable> findAll() {
        return mealTableRepository.findAll();
    }

    public List<MealTable> findByName(String name) {
        return mealTableRepository.findByTableName(name);
    }

}
