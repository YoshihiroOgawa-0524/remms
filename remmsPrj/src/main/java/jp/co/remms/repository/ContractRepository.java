package jp.co.remms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.remms.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
	List<Contract> findByDeleteDateIsNullOrderByContractDateDesc();
	
	Contract findByContractKeyAndDeleteDateIsNull(String contract_key);

}
