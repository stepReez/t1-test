package com.t1.test.service;

import com.t1.test.service.impl.CharCounterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharCounterServiceTest {
    private CharCounterService charCounterService;

    @BeforeEach
    void init() {
        charCounterService = new CharCounterServiceImpl();
    }

    @Test
    void standardTest() {
        Map<String, Integer> map = charCounterService.stringCalculation("aaaaabcccc");
        assertEquals(5, map.get("a"));
        assertEquals(4, map.get("c"));
        assertEquals(1, map.get("b"));
    }


}
