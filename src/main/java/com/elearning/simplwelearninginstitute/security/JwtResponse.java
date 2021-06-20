package com.elearning.simplwelearninginstitute.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	private String token;
	private String userType;
	private String type = "Bearer";
	private Long id;
	private String login;
	private String email;
}
