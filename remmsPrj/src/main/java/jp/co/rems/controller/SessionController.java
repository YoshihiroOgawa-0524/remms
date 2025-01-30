package jp.co.rems.controller;

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

import jp.co.rems.entity.Contract;
import jp.co.rems.entity.User;
import jp.co.rems.repository.ContractRepository;
import jp.co.rems.repository.UserRepository;

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
		Contract contract = contractRepository.findByContractKey(contractKey);
		if(contract != null) {
			this.session.setAttribute("contractName", contract.getContractName());
			this.session.setAttribute("contractKey", contract.getContractKey());
			model.addAttribute("contract", contractRepository.findByContractKey(contractKey));
			return (String) "session/login";
		}
		return "noContract";
	}

	@Autowired
	UserRepository userRepository;
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public String doLoginGet(String userId, String password, Model model) {
		String ContractKey;
		User user = userRepository.findByUserId(userId);
		if(user != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				byte[] hashBytes = md.digest();
				String hash = Base64.getEncoder().encodeToString(hashBytes);
				if(hash.equals(user.getPassword())) {
					ContractKey = (String)this.session.getAttribute("contractKey");
					model.addAttribute("contract", contractRepository.findByContractKey(ContractKey));
					return "customer_list";
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}	
		return "session/login";
	}
	
}
