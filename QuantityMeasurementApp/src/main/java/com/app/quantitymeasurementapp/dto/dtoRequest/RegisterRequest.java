
package com.app.quantitymeasurementapp.dto.dtoRequest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RegisterRequest {
	@NotNull(message = "userName null not allowed")
	private String username;
	@NotNull(message = "email null not allowed")
	private String email;
	@NotNull(message = "password null not allowed")
	private String password;
	@NotNull(message = "role null not allowed")
	private String role;
	
	

	public RegisterRequest(@NotNull(message = "userName null not allowed") String username,
			@NotNull(message = "email null not allowed") String email,
			@NotNull(message = "password null not allowed") String password,
			@NotNull(message = "role null not allowed") String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
