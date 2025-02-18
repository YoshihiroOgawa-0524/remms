package jp.co.remms.form;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContractDetailForm implements Serializable {

	private Long id;

	@NotBlank
//	@Pattern(regexp = "/^[a-zA-Z0-9]+$", message = "契約者IDは半角英数で入力してください")
	private String contractKey;
	
//	@NotBlank
	private Long[] contractType;

	@NotNull
	private LocalDate contractDate;

	@NotBlank
	private String contractName;

	@NotBlank
	private String contractKana;

	@Size(min = 0, max = 7, message = "郵便番号は7桁で入力してください")
//	@Pattern(regexp = "/^[0-9|\0]+$", message = "郵便番号は半角数字で入力してください")
	private String zip;

	private String pref;

	@Size(max = 32, message = "市区町村名を32文字以内で入力してください")
	private String city;

	@Size(max = 32, message = "残りの住所を32文字以内で入力してください")
	private String address;

	@Size(max = 64, message = "ビル名・マンション名を64文字以内で入力してください")
	private String otherAddress;

	@Size(max = 16, message = "連絡先電話番号を16文字以内で入力してください")
	private String tel;

	@NotBlank
	@Size(max = 256, message = "メールアドレスを256文字以内で入力してください")
	@Email(message = "正しいメールアドレスを入力してください")
	private String email;

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

	public Long[] getContractType() {
		return contractType;
	}
	
	public void setContractType(Long[] contractType) {
		this.contractType = contractType;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractKana() {
		return contractKana;
	}

	public void setContractKana(String contractKana) {
		this.contractKana = contractKana;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
