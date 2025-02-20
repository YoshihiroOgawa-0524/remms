package jp.co.remms.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class UserDetailForm implements Serializable {

	private Long id;

	private String contractKey;
	
	private Long contractId;

	@NotBlank
//	@Pattern(regexp = "/^[a-zA-Z0-9]+$", message = "契約者IDは半角英数で入力してください")
	private String userId;
	
	@NotBlank
	private String userName;

	@NotBlank
	private String userKana;
	
	private String password;
	
	private String mode;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getContractKey() {
		return contractKey;
	}
	
	public void setContractKey(String contractKey) {
		this.contractKey = contractKey;
	}

	public Long getContractId() {
		return contractId;
	}
	
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserKana() {
		return userKana;
	}

	public void setUserKana(String userKana) {
		this.userKana = userKana;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
}
