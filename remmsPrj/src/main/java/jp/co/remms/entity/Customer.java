package jp.co.remms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customers_gen")
	@SequenceGenerator(name = "seq_customers_gen", sequenceName = "seq_customers", allocationSize = 1)
	private Integer id;
	
	@Column
	private String customerName;
	
	@Column
	private String customerKana;
	
	@Column
	private String zip;
	
	@Column
	private String prefCd;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String phoneNo;
	
	@Column
	private String faxNo;

	@Column
	private String mobilePhone;

	@Column
	private Integer mediumCd;

	@Column
	private String birthday;

	@Column
	private String email;

	@Column
	private Integer companyCd;

	@Column
	private Integer contractId;

	@Column
	private String memo;
	
	@Column
	private String createDate;
	
	@Column
	private String updateDate;
	
	@Column
	private String deleteDate;
	
	@Column
	private Integer createUser;
	
	@Column
	private Integer updateUser;
	
	@Column
	private Integer deleteUser;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customer_name) {
		this.customerName = customer_name;
	}
	
	public String getCustomerKana() {
		return customerKana;
	}
	
	public void setCustomerKana(String customer_kana) {
		this.customerKana = customer_kana;
	}

	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPrefCd() {
		return prefCd;
	}
	
	public void setPrefCd(String pref_cd) {
		this.prefCd = pref_cd;
	}

	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address_1) {
		this.address1 = address_1;
	}

	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address_2) {
		this.address2 = address_2;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phone_no) {
		this.phoneNo = phone_no;
	}

	public String getFaxNo() {
		return faxNo;
	}
	
	public void setFaxNo(String fax_no) {
		this.faxNo = fax_no;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobile_phone) {
		this.mobilePhone = mobile_phone;
	}

	public Integer getMediumCd() {
		return mediumCd;
	}
	
	public void setMediumCd(Integer medium_cd) {
		this.mediumCd = medium_cd;
	}

	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCompanyCd() {
		return companyCd;
	}
	
	public void setCompanyCd(Integer company_cd) {
		this.companyCd = company_cd;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contract_id) {
		this.contractId = contract_id;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String create_date) {
		this.createDate = create_date;
	}

	public String getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(String update_date) {
		this.updateDate = update_date;
	}

	public String getDeleteDate() {
		return deleteDate;
	}
	
	public void setDeleteDate(String delete_date) {
		this.deleteDate = delete_date;
	}

	public Integer getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(Integer create_user) {
		this.createUser = create_user;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(Integer update_user) {
		this.updateUser = update_user;
	}

	public Integer getDeleteUser() {
		return deleteUser;
	}
	
	public void setDeleteUser(Integer delete_user) {
		this.deleteUser = delete_user;
	}
}
