package com.assignment.Insta.Backend.Basic.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedInputDto {
    private String email;
    private String tokenValue;
}
