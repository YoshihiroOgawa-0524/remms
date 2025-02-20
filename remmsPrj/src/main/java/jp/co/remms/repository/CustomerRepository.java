package jp.co.remms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.remms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByContractIdAndDeleteDateIsNullOrderByCustomerKana(Long contract_id);

	Customer findByContractIdAndDeleteDateIsNull(Long contractId);
	
	Customer findById(Long id);

}
