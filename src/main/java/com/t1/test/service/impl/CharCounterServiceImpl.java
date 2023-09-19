package com.t1.test.service.impl;

import com.t1.test.service.CharCounterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CharCounterServiceImpl implements CharCounterService {
    @Override
    public Map<String, Integer> stringCalculation(String inputString) {
        List<String> stringArr = List.of(inputString.split(""));
        Map<String, Integer> stringCounterMap = new HashMap<>();
        stringArr.forEach((string) -> {
            if (stringCounterMap.containsKey(string)) {
                stringCounterMap.put(string, stringCounterMap.get(string) + 1);
            } else {
                stringCounterMap.put(string, 1);
            }
        });
        Map<String, Integer> sortedMap = stringCounterMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));;
        return sortedMap;
    }
}
