package jp.co.rems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.rems.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(String user_id);
	List<User> findByContractKey(String contract_key);

}
