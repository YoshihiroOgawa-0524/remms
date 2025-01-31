package jp.co.remms.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.remms.entity.Contract;
import jp.co.remms.entity.User;
import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.CustomerRepository;
import jp.co.remms.repository.UserRepository;


@Controller
public class SessionController {
	private HttpSession session;

	@Autowired
	public SessionController(HttpSession session) {
		this.session = session;
	}
	@Autowired
	ContractRepository contractRepository;

	@GetMapping("/login/{id}")
	public String login(@PathVariable("id") String contractKey, Model model) {
		// session情報のクリア
		this.session.setAttribute("contractName", null);
		this.session.setAttribute("contractKey", null);
		this.session.setAttribute("contractId", null);
		// 指定されたKeyにて契約情報を取得
		Contract contract = contractRepository.findByContractKey(contractKey);
		// 契約情報が取得できた場合、sessionに情報を維持
		if(contract != null) {
			this.session.setAttribute("contractName", contract.getContractName());
			this.session.setAttribute("contractKey", contract.getContractKey());
			this.session.setAttribute("contractId", contract.getId());
			// 契約keyにて契約情報を再取得
			model.addAttribute("contract", contractRepository.findByContractKey(contractKey));
			return (String) "session/login";
		}
		// 契約情報が未取得の場合、エラー画面を表示
		return "noContract";
	}

	@Autowired
	UserRepository userRepository;
	CustomerRepository customerRepository;
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public String doLoginGet(String userId, String password, Model model) {
		// 入力されたユーザIDにて、ユーザ情報を取得
		User user = userRepository.findByUserId(userId);
		// ユーザが存在した場合
		if(user != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				byte[] hashBytes = md.digest();
				String hash = Base64.getEncoder().encodeToString(hashBytes);
				// 入力されたパスワードでユーザ情報のパスワードとチェック
				if(hash.equals(user.getPassword())) {
					String ContractKey = (String)this.session.getAttribute("contractKey");
					// sessionが有効
					if(ContractKey != null) {
						// 契約者が管理者
						if(ContractKey.equals("admin")) {
//							model.addAttribute("contracts", contractRepository.findAll());
							model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
							return "contract_list";
							// 契約者は一般の契約者
						} else {
							Integer ContractId = (Integer)this.session.getAttribute("contractId");
							model.addAttribute("customers", customerRepository.findByContractIdAndDeleteDateIsNullOrderByCustomerKana(ContractId));
							return "customer_list";
						}
					}else {
						return "noSession";
					}
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		// ユーザが存在しない場合、ログイン画面を再表示
		String contractKey = (String)this.session.getAttribute("contractKey");
		model.addAttribute("contract", contractRepository.findByContractKey(contractKey));
		return "session/login";
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String doLogoutGet() {
		return (String)"redirect:login/" + this.session.getAttribute("contractKey");
	}
	
}
