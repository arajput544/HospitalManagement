package com.authService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    public AuthResponse(String token2) {
		// TODO Auto-generated constructor stub
	}

	private String token;
}
