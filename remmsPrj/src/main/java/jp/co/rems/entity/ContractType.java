package jp.co.rems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract_types")

public class ContractType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contracts_gen")
	@SequenceGenerator(name = "seq_contracts_gen", sequenceName = "seq_contracts", allocationSize = 1)
	private Integer id;

	@Column
	private String typeName;
	
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String type_name) {
		this.typeName = type_name;
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
