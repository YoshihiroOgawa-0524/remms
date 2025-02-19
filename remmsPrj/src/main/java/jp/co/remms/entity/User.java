package jp.co.remms.entity;

import java.sql.Timestamp;

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

	@Column(name = "user_id")
	private String userId;

	@Column(name = "contract_key")
	private String contractKey;

	@Column(name = "contract_id")
	private Long contractId;

	@Column(name = "name")
	private String name;

	@Column(name = "name_kana")
	private String nameKana;

	@Column(name = "password")
	private String password;

	@Column(name = "type")
	private Integer type;

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

	public Long getContractId() {
		return contractId;
	}
	
	public void setContractId(Long contract_id) {
		this.contractId = contract_id;
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
	
	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
}
