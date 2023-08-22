package com.example.footballmanager.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PlayerRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfStartCareer;
    private Long teamId;
}
