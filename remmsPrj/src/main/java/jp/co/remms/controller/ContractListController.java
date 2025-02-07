package jp.co.remms.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.remms.entity.Contract;
import jp.co.remms.form.ContractDetailForm;
import jp.co.remms.form.ContractSearchForm;
import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.PrefRepository;

@Controller
public class ContractListController {
	private HttpSession session;
	public ContractListController(HttpSession session) {
		this.session = session;
	}

	@Autowired
	ContractRepository contractRepository;
	@Autowired
	PrefRepository prefRepository;
	@Autowired
	EntityManager entityManager;

	@GetMapping("/contract_list")
	public String contractList(ContractSearchForm form, Model model) {
		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@PostMapping("/contract_search")
	public String contractSearch(ContractSearchForm form, Model model) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate fromD = LocalDate.parse("1900/01/01", f);
		LocalDate toD = LocalDate.parse("9999/12/31", f);
		LocalDate fromL = LocalDate.parse("1900/01/01", f);
		LocalDate toL = LocalDate.parse("9999/12/31", f);
		if(form.getFromDate() != null) {
			fromD = form.getFromDate();
		}
		if(form.getToDate() != null) {
			toD = form.getToDate();
		}
		if(form.getFromLimit() != null) {
			fromL = form.getFromLimit();
		}
		if(form.getToLimit() != null) {
			toL = form.getToLimit();
		}
		Query query = entityManager.createNamedQuery("findByContractSearchQuery");
		query.setParameter("key", "%" + form.getSearchKey() + "%");
		query.setParameter("fromDay", fromD);
		query.setParameter("toDay", toD);
		query.setParameter("fromLimit", fromL);
		query.setParameter("toLimit", toL);
		query.setParameter("name", "%" + form.getSearchName() + "%");
		query.setParameter("kana", "%" + form.getSearchKana() + "%");
		model.addAttribute("contracts", query.getResultList());
		return "contract_list";
	}

	@GetMapping("/contract_create")
	public String contractCreate(ContractDetailForm form, Model model) {
		model.addAttribute("prefs", prefRepository.findAll());
		return "contract_create";
	}

	@PostMapping("/contract/insert")
	public String contractInsert(@Valid ContractDetailForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "contract_create";
		}
		Contract chk = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getKey());
		if(chk != null) {
			model.addAttribute("ErrMsg", "契約IDが既に登録されています。");
			return "contract_detail";
		} else {
			Contract contract = new Contract();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			Integer userId = (Integer)this.session.getAttribute("userId");
			LocalDate limitDay = form.getDate().plusYears(1).minusDays(1);
			contract.setContractKey(form.getKey());
			contract.setContractDate(form.getDate());
			contract.setContractName(form.getName());
			contract.setContractKana(form.getKana());
			contract.setZip(form.getZip());
			contract.setPref(form.getPref());
			contract.setCity(form.getCity());
			contract.setAddress(form.getAddress());
			contract.setOtherAddress(form.getOtherAddress());
			contract.setTel(form.getTel());
			contract.setEmail(form.getEmail());
			contract.setContractLimit(limitDay);
			contract.setCreateDate(now);
			contract.setUpdateDate(now);
			contract.setCreateUser(userId);
			contract.setUpdateUser(userId);
			contractRepository.save(contract);
		}
		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@GetMapping("/contract/detail/{key}")
	public String contractDetail(@PathVariable("key") String key, ContractDetailForm form,  Model model) {
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("contract", contractRepository.findByContractKeyAndDeleteDateIsNull(key));
		return "contract_update";
	}

	@PostMapping("/contract/update")
	public String contractUpdate(@Valid ContractDetailForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "contract_update";
		}
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getKey());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		LocalDate limitDay = null;
		if(contract.getContractDate() != form.getDate()) {
			limitDay = form.getDate().plusYears(1).minusDays(1);
		} else {
			limitDay = contract.getContractDate();
		}

		System.out.println("key:" + form.getKey() + " date:" + form.getDate());
		contract.setContractKey(form.getKey());
		contract.setContractDate(form.getDate());
		contract.setContractName(form.getName());
		contract.setContractKana(form.getKana());
		contract.setZip(form.getZip());
		contract.setPref(form.getPref());
		contract.setCity(form.getCity());
		contract.setAddress(form.getAddress());
		contract.setOtherAddress(form.getOtherAddress());
		contract.setTel(form.getTel());
		contract.setEmail(form.getEmail());
		contract.setContractLimit(limitDay);
		contract.setUpdateDate(now);
		contract.setUpdateUser(userId);
		contractRepository.save(contract);

		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@GetMapping("/contract/delete/{key}")
	public String contractDelete(@PathVariable("key") String key, Model model) {
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(key);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");

		contract.setDeleteDate(now);
		contract.setDeleteUser(userId);
		contractRepository.save(contract);

		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}
}
