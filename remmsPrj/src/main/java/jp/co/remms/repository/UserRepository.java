package jp.co.remms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.remms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(String user_id);

	List<User> findByContractKey(String contract_key);

	User findByContractKeyAndUserIdAndDeleteDateIsNull(String contract_key, String userId);

	User findByContractKeyAndDeleteDateIsNullOrderById(String contract_key);

	void deleteByContractKey(String contract_key);

}
