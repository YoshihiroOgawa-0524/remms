package jp.co.rems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users_gen")
	@SequenceGenerator(name = "seq_users_gen", sequenceName = "seq_users", allocationSize = 1)
	private Integer id;

	@Column
	private String userId;

	@Column
	private String contractKey;

	@Column
	private String name;

	@Column
	private String nameKana;

	@Column
	private String password;

	@Column
	private Integer type;

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
	
	@ManyToOne
	@JoinColumn(name = "contract_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Contract contract;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user_id) {
		this.userId = user_id;
	}

	public String getContractKey() {
		return contractKey;
	}

	public void setContractKey(String contract_key) {
		this.contractKey = contract_key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKana() {
		return nameKana;
	}

	public void setNameKana(String name_kana) {
		this.nameKana = name_kana;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
	
	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
}
