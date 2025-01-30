package jp.co.remms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.UserRepository;

@Controller
public class ContractListController {
//	private HttpSession session;
//
//	@Autowired
//	public ContractListController(HttpSession session) {
//		this.session = session;
//	}
	@Autowired
	ContractRepository contractRepository;
	UserRepository userRepository;

	@RequestMapping(path = "/contract_list", method = RequestMethod.GET)
	public String contractList(Model model) {
		model.addAttribute("contract", contractRepository.findAll());
		return "contract_list";
	}

}
