package com.checkmeal.controller;

import com.checkmeal.domain.MealTable;
import com.checkmeal.service.MealTableServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class MealTableControllerUnitTest {

    private static final String CITY1 = "Porto";
    private static final String CITY2 = "Braga";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MealTableServiceImpl mealTableService;

    List<MealTable> mealTablesList;

    @Before
    public void setup() {
        mealTablesList = new ArrayList<MealTable>();
        MealTable mt1 = new MealTable(CITY1);
        MealTable mt2 = new MealTable(CITY2);
        mealTablesList.add(mt1);
        mealTablesList.add(mt2);
    }

    @Test
    public void getMealTables_whenOk() throws Exception {
        when(mealTableService.findAll()).thenReturn(mealTablesList);

        mockMvc.perform(get("/mealtables/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tableName", is(CITY1)))
                .andExpect(jsonPath("$[1].tableName", is(CITY2)));
    }

    @Test
    public void getMealTablesSearch_whenOk() throws Exception {
        when(mealTableService.findByName(CITY1)).thenReturn(mealTablesList.subList(0, 1));

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("tableName", CITY1);

        mockMvc.perform(get("/mealtables/search?tableName=Porto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tableName", is(CITY1)));
    }
}
