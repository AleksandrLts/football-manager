package com.example.footballmanager.dto.response;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String name;
    private String country;
    private Set<Long> playersIds;
    private BigDecimal balance;
    private BigDecimal commission;
}
