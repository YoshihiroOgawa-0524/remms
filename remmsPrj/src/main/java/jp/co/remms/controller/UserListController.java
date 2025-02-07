package jp.co.remms.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.UserRepository;

@Controller
public class UserListController {
	private HttpSession session;

	@Autowired
	public UserListController(HttpSession session) {
		this.session = session;
	}
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/user_list")
	public String userList(Model model) {
		String contractKey = (String)this.session.getAttribute("contractKey");
		model.addAttribute("contract", contractRepository.findByContractKey(contractKey));
		System.out.println("ContractKey:" + contractKey);
		model.addAttribute("users", userRepository.findByContractKey(contractKey));
		return "user_list";
	}

}
