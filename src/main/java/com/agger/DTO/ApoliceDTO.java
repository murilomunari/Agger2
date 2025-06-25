package com.agger.DTO;

import com.agger.Model.Client;

import java.time.LocalDateTime;

public record ApoliceDTO(String number,
                         LocalDateTime dataTime,
                         String clientId) {
}
