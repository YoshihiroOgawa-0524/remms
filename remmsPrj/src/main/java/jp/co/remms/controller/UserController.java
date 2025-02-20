package jp.co.remms.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Base64;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.remms.entity.Contract;
import jp.co.remms.entity.User;
import jp.co.remms.form.ContractSearchForm;
import jp.co.remms.form.UserDetailForm;
import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.UserRepository;

@Controller
public class UserController {
	private HttpSession session;

	@Autowired
	public UserController(HttpSession session) {
		this.session = session;
	}
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContractRepository contractRepository;

	@GetMapping("/user_list")
	public String userList(Model model) {
		String contractKey = (String)this.session.getAttribute("contractKey");
		System.out.println("ContractKey:" + contractKey);
		model.addAttribute("users", userRepository.findByContractKeyAndDeleteDateIsNullOrderById(contractKey));
		return "user_list";
	}

	@GetMapping("/user_create")
	public String userCreate(@ModelAttribute UserDetailForm form, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 新規登録画面の設定
		model.addAttribute("type", "insert");
		model.addAttribute("label", "登録");
		return "user_detail";
	}

	@PostMapping("/user/insert")
//	public String userInsert(@PathVariable("mode") String mode, @Validated @ModelAttribute UserDetailForm form, BindingResult result, Model model) {
	public String userInsert(@Validated @ModelAttribute UserDetailForm form, BindingResult result, @ModelAttribute ContractSearchForm form1, Model model) {
		// セッション切れ対応
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// ユーザ画面のヴァリデーションチェック
		if(result.hasErrors()) {
			model.addAttribute("type", "insert");
			model.addAttribute("label", "登録");
			return "user_detail";
		}
		// ユーザIDの二重登録チェック
		User chk = userRepository.findByContractKeyAndUserIdAndDeleteDateIsNull(form.getContractKey(), form.getUserId());
		if(chk != null) {
			model.addAttribute("errs", "既に同一のユーザIDが使用されています。");
			return "user_detail";
		}
		// 新規契約登録
		User user = new User();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		user.setUserId(form.getUserId());
		user.setName(form.getUserName());
		user.setNameKana(form.getUserKana());
		System.out.println("ContractKey=" + form.getContractKey());
		user.setContractKey(form.getContractKey());
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getContractKey());
		user.setContractId(contract.getId());
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(form.getUserId().getBytes());
			byte[] hashBytes = md.digest();
			String hash = Base64.getEncoder().encodeToString(hashBytes);
			user.setPassword(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		user.setType(1);
		user.setCreateDate(now);
		user.setUpdateDate(now);
		user.setCreateUser(userId);
		user.setUpdateUser(userId);
		userRepository.save(user);
		System.out.println("USER=" + form.getMode());
		if(form.getMode().equals("admin")) {
			System.out.println("ADMIN");
			// 契約一覧表示
			model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
			return "contract_list";
		} else {
			// ユーザ一覧表示
			System.out.println("OTHER");
			model.addAttribute("users", userRepository.findByContractKeyAndDeleteDateIsNullOrderById(form.getContractKey()));
			return "user_list";
		}
	}
}
