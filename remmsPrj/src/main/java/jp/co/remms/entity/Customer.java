package jp.co.remms.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@NamedQuery(name="findByCustomerSearchQuery", query="SELECT c FROM Customer c WHERE  c.customerName LIKE :name AND c.customerKana LIKE :kana AND (c.phoneNo = :contact or c.faxNo = :contact or c.mobilePhone = :contact) AND c.deleteDate IS NULL ORDER BY c.customerKana")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customers_gen")
	@SequenceGenerator(name = "seq_customers_gen", sequenceName = "seq_customers", allocationSize = 1)
	private Long id;
	
	@Column(name = "contract_id")
	private Long contractId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_kana")
	private String customerKana;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "pref_cd")
	private String prefCd;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "other_address")
	private String otherAddress;
	
	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "fax_no")
	private String faxNo;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Column(name = "compay_id")
	private Long companyId;

	@Column(name = "medium_id")
	private Long mediumId;

	@Column(name = "memo")
	private String memo;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "update_date")
	private Timestamp updateDate;
	
	@Column(name = "delete_date")
	private Timestamp deleteDate;
	
	@Column(name = "create_user")
	private Integer createUser;
	
	@Column(name = "update_user")
	private Integer updateUser;
	
	@Column(name = "delete_user")
	private Integer deleteUser;

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

	public Long getMediumId() {
		return mediumId;
	}
	
	public void setMediumId(Long mediumId) {
		this.mediumId = mediumId;
	}

	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Timestamp create_date) {
		this.createDate = create_date;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Timestamp update_date) {
		this.updateDate = update_date;
	}

	public Timestamp getDeleteDate() {
		return deleteDate;
	}
	
	public void setDeleteDate(Timestamp delete_date) {
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
