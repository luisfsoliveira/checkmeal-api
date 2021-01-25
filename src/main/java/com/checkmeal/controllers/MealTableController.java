package com.checkmeal.controllers;

import com.checkmeal.domain.MealOrder;
import com.checkmeal.domain.MealTable;
import com.checkmeal.service.IMealOrderService;
import com.checkmeal.service.IMealTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  MealTableController is the API Endpoint for ...example example
 *  example
 *
 * Endpoint: /mealtables
 *
 */
@RestController
@RequestMapping("/mealtables")
public class MealTableController {

    @Autowired
    private IMealTableService mealTableService;

    /**
     * This method...example example example
     *
     * Endpoint: /mealtables/all GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("all")
    @ResponseBody
    public Collection<MealTable> getMealTables(){
        return mealTableService.findAll();
    }

    /**
     * This method...example example example
     *
     * Endpoint: /mealtables/search GET
     * Request: ...
     * Response: ..
     * Response codes: ...
     *
     */
    @GetMapping("search")
    @ResponseBody
    public Collection<MealTable> getMealTables(@RequestParam(required=true) String tableName){
        return mealTableService.findByName(tableName);
    }

}
