package com.nakta.springlv1.dto;

import lombok.Getter;

@Getter
public class StringResponseDto {
    String message;
    public StringResponseDto(String message) {
        this.message = message;
    }
}
