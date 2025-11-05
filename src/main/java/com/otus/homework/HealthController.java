package com.otus.homework;

import com.otus.homework.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    ResponseEntity<ResponseDto> health() {
        return ResponseEntity.ok(new ResponseDto("OK"));
    }
}
