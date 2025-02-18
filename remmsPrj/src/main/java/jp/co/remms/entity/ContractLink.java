package jp.co.remms.entity;

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
@Table(name = "contract_links")

public class ContractLink {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contract_links_gen")
	@SequenceGenerator(name = "seq_contract_links_gen", sequenceName = "seq_contract_links", allocationSize = 1)
	private Integer id;
	
	@Column(name = "contract_id")
	private Long contractId;	
	
	@Column(name = "contract_type_id")
	private Long contractTypeId;

	@ManyToOne
	@JoinColumn(name = "contract_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name = "contract_type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ContractType contractType;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Long getContractId() {
		return contractId;
	}
	
	public void setContractId(Long contract_id) {
		this.contractId = contract_id;
	}
	
	public Long getContractTypeId() {
		return contractTypeId;
	}
	
	public void setContractTypeId(Long contract_type_id) {
		this.contractTypeId = contract_type_id;
	}
	
	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public ContractType getContractType() {
		return contractType;
	}
	
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
}
