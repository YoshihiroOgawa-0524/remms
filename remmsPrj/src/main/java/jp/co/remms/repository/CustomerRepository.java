package jp.co.remms.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.remms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByContractId(Integer contract_id);
}
