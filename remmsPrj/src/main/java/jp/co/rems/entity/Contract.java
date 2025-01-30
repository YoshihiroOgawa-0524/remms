package jp.co.rems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contracts")

public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contracts_gen")
	@SequenceGenerator(name = "seq_contracts_gen", sequenceName = "seq_contracts", allocationSize = 1)
	private Integer id;
	
	@Column
	private String contractKey;
	
	@Column
	private String contractName;
	
	@Column
	private String contractKana;
	
	@Column
	private String contractDate;
	
	@Column
	private String zip;
	
	@Column
	private String pref;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String tel;
	
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

	public String getContractDate() {
		return contractDate;
	}
	
	public void setContractDate(String contract_date) {
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

	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
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
