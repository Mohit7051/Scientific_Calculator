package com.itvedant.scientificcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ScientificCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScientificCalculatorApplication.class, args);
    }

    @GetMapping("/calculate")
    public Map<String, Double> calculate(
            @RequestParam("operation") String operation,
            @RequestParam("num1") double num1,
            @RequestParam(value = "num2", required = false, defaultValue = "0") double num2) {
        Map<String, Double> result = new HashMap<>();
        switch (operation) {
            case "add":
                result.put("result", num1 + num2);
                break;
            case "sub":
                result.put("result", num1 - num2);
                break;
            case "mul":
                result.put("result", num1 * num2);
                break;
            case "div":
                if (num2 != 0) {
                    result.put("result", num1 / num2);
                } else {
                    result.put("error", Double.NaN);
                }
                break;
            case "sin":
                result.put("result", Math.sin(num1));
                break;
            case "cos":
                result.put("result", Math.cos(num1));
                break;
            case "tan":
                result.put("result", Math.tan(num1));
                break;
            case "log":
                if (num1 > 0 && num2 > 0) {
                    result.put("result", Math.log(num1) / Math.log(num2));
                } else {
                    result.put("error", Double.NaN);
                }
                break;
            case "pi":
                result.put("result", Math.PI);
                break;
            case "exp":
                result.put("result", Math.exp(num1));
                break;
            default:
                result.put("error", Double.NaN);
                break;
        }
        return result;
    }
}
