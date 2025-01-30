package jp.co.rems.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.rems.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
	Contract findByContractKey(String contract_key);
}
