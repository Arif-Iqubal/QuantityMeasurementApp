
package com.app.quantitymeasurementapp.controller;

import com.app.quantitymeasurementapp.dto.dtoResponse.AuthResponse;
import com.app.quantitymeasurementapp.service.GoogleAuthService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController {

	@Autowired
	private GoogleAuthService googleAuthService;

	@GetMapping
	public void googleLogin(HttpServletResponse response) throws IOException {
		String googleUrl = "https://accounts.google.com/o/oauth2/v2/auth"
				+ "?client_id=511021883613-sgm4qh82a51ig8ctggp005j13nl33bgb.apps.googleusercontent.com"
				+ "&redirect_uri=http://localhost:8080/auth/google/callback" + "&response_type=code"
				+ "&scope=email profile";

		response.sendRedirect(googleUrl);
	}

//	@GetMapping("/callback")
//	public ResponseEntity<AuthResponse> handleGoogleCallback(@RequestParam String code) {
//		return ResponseEntity.ok(googleAuthService.handleGoogleAuth(code));
//	}
//	@GetMapping("/callback")
//	public ResponseEntity<?> handleGoogleCallback(@RequestParam(required = false) String code) {
//
//	    if (code == null) {
//	        return ResponseEntity.badRequest().body("Missing code parameter");
//	    }
//
//	    return ResponseEntity.ok(googleAuthService.handleGoogleAuth(code));
//	}
	@GetMapping("/callback")
	public void handleGoogleCallback(@RequestParam String code, HttpServletResponse response) throws IOException {

		AuthResponse auth = googleAuthService.handleGoogleAuth(code);

		String redirectUrl = "http://localhost:4200/auth?token=" + auth.getToken();

		response.sendRedirect(redirectUrl);
	}
}
