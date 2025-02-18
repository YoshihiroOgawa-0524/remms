package jp.co.remms.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.remms.entity.Contract;
import jp.co.remms.entity.ContractLink;
import jp.co.remms.form.ContractDetailForm;
import jp.co.remms.form.ContractSearchForm;
import jp.co.remms.repository.ContractLinkRepository;
import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.ContractTypeRepository;
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
	ContractTypeRepository contractTypeRepository;
	@Autowired
	ContractLinkRepository contractLinkRepository;
	@Autowired
	EntityManager entityManager;

	@GetMapping("/contract_list")
	public String contractList(@ModelAttribute ContractSearchForm form, Model model) {
		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@PostMapping("/contract_search")
	public String contractSearch(@ModelAttribute ContractSearchForm form, Model model) {
		// 検索用日付の
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fromD = LocalDate.parse("1900-01-01", f);
		LocalDate toD = LocalDate.parse("9999-12-31", f);
		LocalDate fromL = LocalDate.parse("1900-01-01", f);
		LocalDate toL = LocalDate.parse("9999-12-31", f);
		// 検索用契約日
		if(form.getFromDate() != null) {
			fromD = form.getFromDate();
		}
		if(form.getToDate() != null) {
			toD = form.getToDate();
		}
		// 検索用契約満了日
		if(form.getFromLimit() != null) {
			fromL = form.getFromLimit();
		}
		if(form.getToLimit() != null) {
			toL = form.getToLimit();
		}
		// 検索用パラメータ設定
		Query query = entityManager.createNamedQuery("findByContractSearchQuery");
		query.setParameter("key", "%" + form.getSearchKey() + "%");
		query.setParameter("fromDay", fromD);
		query.setParameter("toDay", toD);
		query.setParameter("fromLimit", fromL);
		query.setParameter("toLimit", toL);
		query.setParameter("name", "%" + form.getSearchName() + "%");
		query.setParameter("kana", "%" + form.getSearchKana() + "%");
		// 検索結果表示
		model.addAttribute("contracts", query.getResultList());
		return "contract_list";
	}

	@GetMapping("/contract_create")
	public String contractCreate(@ModelAttribute ContractDetailForm form, Model model) {
		// 新規登録画面の設定
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("contractTypes", contractTypeRepository.findByDeleteDateIsNullOrderById());
		model.addAttribute("type", "insert");
		model.addAttribute("label", "登録");
		return "contract_detail";
	}

	@PostMapping("/contract/insert")
	public String contractInsert(@Validated @ModelAttribute ContractDetailForm form, BindingResult result, @ModelAttribute ContractSearchForm form1, Model model) {
		// 契約画面のヴァリデーションチェック
		if(result.hasErrors()) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("type", "insert");
			model.addAttribute("label", "登録");
			return "contract_detail";
		}
		// 契約IDの二重登録チェック
		Contract chk = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getContractKey());
		if(chk != null) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("errs", "既に同一の契約IDが使用されています。");
			return "contract_detail";
		}
		// 契約タイプのチェック
		Long[] type = form.getContractType();
		if(type.length == 0) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("errs", "契約タイプを選択してください。");
			return "contract_detail";
		}
		// 新規契約登録
		Contract contract = new Contract();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		LocalDate limitDay = form.getContractDate().plusYears(1).minusDays(1);
		contract.setContractKey(form.getContractKey());
		contract.setContractName(form.getContractName());
		contract.setContractKana(form.getContractKana());
		contract.setContractStartDate(form.getContractDate());
		contract.setContractDate(form.getContractDate());
		contract.setContractLimit(limitDay);
		contract.setZip(form.getZip());
		contract.setPref(form.getPref());
		contract.setCity(form.getCity());
		contract.setAddress(form.getAddress());
		contract.setOtherAddress(form.getOtherAddress());
		contract.setTel(form.getTel());
		contract.setEmail(form.getEmail());
		contract.setCreateDate(now);
		contract.setUpdateDate(now);
		contract.setCreateUser(userId);
		contract.setUpdateUser(userId);
		contractRepository.save(contract);
		// 新規契約リンク登録
		Contract new_contract = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getContractKey());			
		Arrays.stream(type).forEach(s -> {
			ContractLink contractLink = new ContractLink();
			contractLink.setContractId(new_contract.getId());
			contractLink.setContractTypeId(s);
			contractLinkRepository.save(contractLink);
		});
		// 契約一覧表示
		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@GetMapping("/contract/change/{key}")
	public String contractDetail(@PathVariable("key") String key, @ModelAttribute ContractDetailForm form,  Model model) {
		// 契約修正画面の設定
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(key);
		form.setId(contract.getId());
		form.setContractKey(contract.getContractKey());
		Long[] contractType = new Long[10];
		int i = 0;
		List<ContractLink> contractLinks = contractLinkRepository.findByContractId(contract.getId());
		for(ContractLink contractLink: contractLinks) {
			contractType[i] = contractLink.getContractTypeId();
			i++;
		}
		form.setContractType(contractType);
		form.setContractDate(contract.getContractDate());
		form.setContractName(contract.getContractName());
		form.setContractKana(contract.getContractKana());
		form.setZip(contract.getZip());
		form.setPref(contract.getPref());
		form.setCity(contract.getCity());
		form.setAddress(contract.getAddress());
		form.setOtherAddress(contract.getOtherAddress());
		form.setTel(contract.getTel());
		form.setEmail(contract.getEmail());
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("contractTypes", contractTypeRepository.findByDeleteDateIsNullOrderById());
		model.addAttribute("type", "update");
		model.addAttribute("label", "更新");
		return "contract_detail";
	}

	@PostMapping("/contract/update")
	public String contractUpdate(@Validated @ModelAttribute ContractDetailForm form, BindingResult result, @ModelAttribute ContractSearchForm form1, Model model) {
		// 契約画面のヴァリデーションチェック
		if(result.hasErrors()) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("contractTypes", contractTypeRepository.findByDeleteDateIsNullOrderById());
			model.addAttribute("type", "update");
			model.addAttribute("label", "更新");
			return "contract_detail";
		}
		// 更新対象データの取得
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(form.getContractKey());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		LocalDate limitDay = null;
		if(contract.getContractDate() != form.getContractDate()) {
			limitDay = form.getContractDate().plusYears(1).minusDays(1);
		} else {
			limitDay = contract.getContractDate();
		}
		Long[] type = form.getContractType();
		
		contract.setContractKey(form.getContractKey());
		contract.setContractDate(form.getContractDate());
		contract.setContractName(form.getContractName());
		contract.setContractKana(form.getContractKana());
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
		// 契約リンク削除
		List<ContractLink> contractLinks = contractLinkRepository.findByContractId(form.getId());
		for(ContractLink contractLink: contractLinks) {
			contractLinkRepository.deleteById(contractLink.getId());
		}
		// 更新契約リンク登録
		Arrays.stream(type).forEach(s -> {
			ContractLink contractLink = new ContractLink();
			contractLink.setContractId(form.getId());
			contractLink.setContractTypeId(s);
			contractLinkRepository.save(contractLink);
		});
		// 契約一覧表示
		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}

	@GetMapping("/contract/destroy/{key}")
	public String contractDestroy(@PathVariable("key") String key, @ModelAttribute ContractDetailForm form, Model model) {
		// 契約削除画面の設定
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(key);
		form.setContractKey(contract.getContractKey());
		Long[] contractType = new Long[10];
		int i = 0;
		List<ContractLink> contractLinks = contractLinkRepository.findByContractId(contract.getId());
		for(ContractLink contractLink: contractLinks) {
			contractType[i] = contractLink.getContractTypeId();
			i++;
		}
		form.setContractType(contractType);
		form.setContractDate(contract.getContractDate());
		form.setContractName(contract.getContractName());
		form.setContractKana(contract.getContractKana());
		form.setZip(contract.getZip());
		form.setPref(contract.getPref());
		form.setCity(contract.getCity());
		form.setAddress(contract.getAddress());
		form.setOtherAddress(contract.getOtherAddress());
		form.setTel(contract.getTel());
		form.setEmail(contract.getEmail());
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("contractTypes", contractTypeRepository.findByDeleteDateIsNullOrderById());
		model.addAttribute("type", "delete");
		model.addAttribute("label", "削除");
		model.addAttribute("contractKey", contract.getContractKey());
		return "contract_detail";
	}

	@PostMapping("/contract/delete")
	public String contractDelete(@ModelAttribute ContractDetailForm form, @ModelAttribute ContractSearchForm form1, Model model) {
		String key = form.getContractKey();
		Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(key);
		// 更新契約リンク登録
		Long[] type = form.getContractType();
		Arrays.stream(type).forEach(s -> {
			ContractLink contractLink = new ContractLink();
			contractLink.setContractId(form.getId());
			contractLink.setContractTypeId(s);
			contractLinkRepository.save(contractLink);
		});
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");

		contract.setDeleteDate(now);
		contract.setDeleteUser(userId);
		contractRepository.save(contract);

		model.addAttribute("contracts", contractRepository.findByDeleteDateIsNullOrderByContractDateDesc());
		return "contract_list";
	}
}
