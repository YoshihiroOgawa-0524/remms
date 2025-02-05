package jp.co.remms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.remms.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
	Contract findByContractKey(String contract_key);
	
	List<Contract> findByDeleteDateIsNullOrderByContractDateDesc();
	
	Contract findByContractKeyAndDeleteDateIsNull(String contract_key);
}
