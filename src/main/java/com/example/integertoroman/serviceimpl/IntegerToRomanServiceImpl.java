package com.example.integertoroman.serviceimpl;
import com.example.integertoroman.exception.OutOfBound;
import com.example.integertoroman.service.IntegerToRomanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class IntegerToRomanServiceImpl implements IntegerToRomanService {

    private final List<Integer> numeralInteger;

    private Integer number;

    @Value("${limit.integer.range}")
    private Integer max;

    private final List<String> numeralRoman;

    public IntegerToRomanServiceImpl(@Value("${numeral.mapping.decimal}") List<Integer> numeralInteger, @Value("${numeral.mapping.roman}") List<String> numeralRoman) {
        this.numeralInteger = numeralInteger;
        this.numeralRoman = numeralRoman;
    }

    @Override
    public String getRoman(Integer number, String roman) {

        if(number > max){
            throw new OutOfBound("Integer out of bound");
        }

        if (number == 0) {
            return roman;
        }

        for (int i = numeralInteger.size()-1; i >= 0; i--) {
            if (number >= numeralInteger.get(i)) {

                return getRoman(number - numeralInteger.get(i), roman + numeralRoman.get(i));
            }
        }

        return roman;
    }

    @Override
    public String getNUmber(Integer number) {
        this.number = number;
        return convertIntegerToRoman();
    }

    @Override
    public String convertIntegerToRoman() {
        return getRoman(number, "");
    }
}
