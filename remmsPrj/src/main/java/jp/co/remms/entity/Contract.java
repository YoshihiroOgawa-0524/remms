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
@Table(name = "contracts")
@NamedQuery(name="findByContractSearchQuery", query="SELECT c FROM Contract c WHERE c.contractKey LIKE :key AND c.contractDate BETWEEN :fromDay AND :toDay AND c.contractLimit BETWEEN :fromLimit AND :toLimit AND c.contractName LIKE :name AND c.contractKana LIKE :kana AND c.deleteDate IS NULL ORDER BY c.contractDate DESC")

public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contracts_gen")
	@SequenceGenerator(name = "seq_contracts_gen", sequenceName = "seq_contracts", allocationSize = 1)
	private Long id;
	
	@Column(name = "contract_key")
	private String contractKey;
	
	@Column(name = "contract_name")
	private String contractName;
	
	@Column(name = "contract_kana")
	private String contractKana;
	
	@Column(name = "contract_date")
	private LocalDate contractDate;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "pref")
	private String pref;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "other_address")
	private String otherAddress;
	
	@Column(name = "tel")
	private String tel;

	@Column(name = "email")
	private String email;

	@Column(name = "contract_limit")
	private LocalDate contractLimit;

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
	
	public String getContractKey() {
		return contractKey;
	}

	public void setContractKey(String contract_key) {
		this.contractKey = contract_key;
	}
	
	public String getContractName() {
		return contractName;
	}
	
	public void setContractName(String contract_name) {
		this.contractName = contract_name;
	}
	
	public String getContractKana() {
		return contractKana;
	}
	
	public void setContractKana(String contract_kana) {
		this.contractKana = contract_kana;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}
	
	public void setContractDate(LocalDate contract_date) {
		this.contractDate = contract_date;
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
	
	public void setOtherAddress(String other_address) {
		this.otherAddress = other_address;
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

	public LocalDate getContractLimit() {
		return contractLimit;
	}
	
	public void setContractLimit(LocalDate contract_limit) {
		this.contractLimit = contract_limit;
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
