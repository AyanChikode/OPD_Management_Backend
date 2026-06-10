package com.OPD_Management_Backend.OPD_Management_Backend.security;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.OPD_Management_Backend.OPD_Management_Backend.response.ErrorResponce;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
						HttpServletResponse response,
						AuthenticationException authException)
				throws IOException, ServletException {
		
		// 1. create a custom error response
		ErrorResponce error = new ErrorResponce(
				HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Invalid or missing JWT token", LocalDateTime.now()
				);
		// 2. set HTTP status as 401 (unauthorized)
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// 3. set response content type as JSON
        response.setContentType("application/json");

        // 4. Write error response to HTTP output stream
        new ObjectMapper().writeValue(response.getOutputStream(), error);
	}
}
