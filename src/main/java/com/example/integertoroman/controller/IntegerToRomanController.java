package com.example.integertoroman.controller;
import com.example.integertoroman.response.ErrorResponseDto;
import com.example.integertoroman.response.RequestNumberDto;
import com.example.integertoroman.service.IntegerToRomanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class IntegerToRomanController {

    private final IntegerToRomanService integerToRomanService;

    public IntegerToRomanController(IntegerToRomanService integerToRomanService) {
        this.integerToRomanService = integerToRomanService;
    }

    @PostMapping("/number")
    public ResponseEntity<String> getNumber(@RequestBody RequestNumberDto requestNumberDto) {
        return ResponseEntity.ok(integerToRomanService.getNUmber(Integer.parseInt(requestNumberDto.getNum())));
    }

}
