package jp.co.remms.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginForm {
	@NotNull
	@Size(max = 16)
	private String userId;
	
	@NotNull
	@Size(min = 4, max = 16)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
