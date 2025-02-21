package jp.co.remms.form;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDetailForm implements Serializable {

	private Long id;

//	@Pattern(regexp = "/^[a-zA-Z0-9]+$", message = "契約者IDは半角英数で入力してください")
	private Long contractId;
	
	@NotBlank
	private String customerName;

	@NotBlank
	private String customerKana;

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

	private LocalDate birthday;

	@NotBlank
	@Size(max = 256, message = "メールアドレスを256文字以内で入力してください")
	@Email(message = "正しいメールアドレスを入力してください")
	private String email;
	
	@Size(max = 16, message = "連絡先電話番号を16文字以内で入力してください")
	private String phoneNo;
	
	@Size(max = 16, message = "連絡先FAX番号を16文字以内で入力してください")
	private String faxNo;
	
	@Size(max = 16, message = "連絡先FAX番号を16文字以内で入力してください")
	private String mobilePhone;

	private String memo;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerKana() {
		return customerKana;
	}

	public void setCustomerKana(String customerKana) {
		this.customerKana = customerKana;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
