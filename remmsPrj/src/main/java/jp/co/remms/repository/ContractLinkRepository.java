package jp.co.remms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.remms.entity.ContractLink;

@Repository
public interface ContractLinkRepository extends JpaRepository<ContractLink, Integer> {

	List<ContractLink> findByContractId(Long contract_id);

}
