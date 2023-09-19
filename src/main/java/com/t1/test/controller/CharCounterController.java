package com.t1.test.controller;

import com.t1.test.service.CharCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Validated
public class CharCounterController {

    private final CharCounterService charCounterService;

    @GetMapping
    public Map<String, Integer> stringCalculation(@RequestParam @NotBlank(message = "String cant be blank") String string) {
        return charCounterService.stringCalculation(string);
    }
}
