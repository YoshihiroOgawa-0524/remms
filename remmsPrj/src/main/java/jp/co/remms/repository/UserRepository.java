package jp.co.remms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.remms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(String user_id);
	List<User> findByContractKey(String contract_key);

}
