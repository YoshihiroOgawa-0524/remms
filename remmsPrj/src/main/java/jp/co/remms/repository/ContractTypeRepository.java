package jp.co.remms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.remms.entity.ContractType;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {

	List<ContractType> findByDeleteDateIsNullOrderById();

}
