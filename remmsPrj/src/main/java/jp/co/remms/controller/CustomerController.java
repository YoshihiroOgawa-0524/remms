package jp.co.remms.controller;

import java.sql.Timestamp;

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

import jp.co.remms.entity.Customer;
import jp.co.remms.form.ContractSearchForm;
import jp.co.remms.form.CustomerDetailForm;
import jp.co.remms.form.CustomerSearchForm;
import jp.co.remms.form.UserDetailForm;
import jp.co.remms.repository.ContractLinkRepository;
import jp.co.remms.repository.ContractRepository;
import jp.co.remms.repository.ContractTypeRepository;
import jp.co.remms.repository.CustomerRepository;
import jp.co.remms.repository.PrefRepository;
import jp.co.remms.repository.UserRepository;

@Controller
public class CustomerController {
	private HttpSession session;
	public CustomerController(HttpSession session) {
		this.session = session;
	}

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	PrefRepository prefRepository;
	@Autowired
	ContractTypeRepository contractTypeRepository;
	@Autowired
	ContractLinkRepository contractLinkRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EntityManager entityManager;

	@GetMapping("/customer_list")
	public String customerList(@ModelAttribute CustomerSearchForm form, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		Long contractId = (Long)this.session.getAttribute("contractId");
		model.addAttribute("customers", customerRepository.findByContractIdAndDeleteDateIsNullOrderByCustomerKana(contractId));
		return "contract_list";
	}

	@PostMapping("/customer_search")
	public String customerSearch(@ModelAttribute CustomerSearchForm form, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 検索用パラメータ設定
		Query query = entityManager.createNamedQuery("findByCustomerSearchQuery");
		query.setParameter("name", "%" + form.getCustomerName() + "%");
		query.setParameter("kana", "%" + form.getCustomerKana() + "%");
		query.setParameter("contact", form.getContactAddress());
		// 検索結果表示
		model.addAttribute("customers", query.getResultList());
		return "customer_list";
	}

	@GetMapping("/customer_create")
	public String customerCreate(@ModelAttribute CustomerDetailForm form, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 新規登録画面の設定
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("contractTypes", contractTypeRepository.findByDeleteDateIsNullOrderById());
		model.addAttribute("type", "insert");
		model.addAttribute("label", "登録");
		return "customer_detail";
	}

	@PostMapping("/customer/insert")
	public String customerInsert(@Validated @ModelAttribute CustomerDetailForm form, BindingResult result, @ModelAttribute ContractSearchForm form1, @ModelAttribute UserDetailForm form2, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 顧客画面のヴァリデーションチェック
		if(result.hasErrors()) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("type", "insert");
			model.addAttribute("label", "登録");
			return "customer_detail";
		}
		// 顧客名称の二重登録チェック
//		Customer chk = customerRepository.findByContractIdAndDeleteDateIsNull(form.getContractId());
//		if(chk != null) {
//			model.addAttribute("prefs", prefRepository.findAll());
//			model.addAttribute("errs", "既に同一の顧客名称が使用されています。");
//			return "customer_detail";
//		}
		// 新規契約登録
		Customer customer = new Customer();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		customer.setContractId(form.getContractId());
		customer.setCustomerName(form.getCustomerName());
		customer.setCustomerKana(form.getCustomerKana());
		customer.setZip(form.getZip());
		customer.setPrefCd(form.getPref());
		customer.setCity(form.getCity());
		customer.setAddress(form.getAddress());
		customer.setOtherAddress(form.getOtherAddress());
		customer.setEmail(form.getEmail());
		customer.setPhoneNo(form.getPhoneNo());
		customer.setCreateDate(now);
		customer.setUpdateDate(now);
		customer.setCreateUser(userId);
		customer.setUpdateUser(userId);
		customerRepository.save(customer);
		model.addAttribute("customers", customerRepository.findByContractIdAndDeleteDateIsNullOrderByCustomerKana(form.getContractId()));
		return "customer_list";
	}

	@GetMapping("/customer/change/{key}")
	public String customerDetail(@PathVariable("key") String key, @ModelAttribute CustomerDetailForm form,  Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 顧客修正画面の設定
		Long id = Long.parseLong(key);
		Customer customer = customerRepository.findById(id);
		form.setId(id);
		form.setContractId(customer.getContractId());
		form.setCustomerName(customer.getCustomerName());
		form.setCustomerKana(customer.getCustomerKana());
		form.setZip(customer.getZip());
		form.setPref(customer.getPrefCd());
		form.setCity(customer.getCity());
		form.setAddress(customer.getAddress());
		form.setOtherAddress(customer.getOtherAddress());
		form.setBirthday(customer.getBirthday());
		form.setEmail(customer.getEmail());
		form.setPhoneNo(customer.getPhoneNo());
		form.setFaxNo(customer.getFaxNo());
		form.setMobilePhone(customer.getMobilePhone());
		form.setMemo(customer.getMemo());
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("type", "update");
		model.addAttribute("label", "更新");
		return "customer_detail";
	}

	@PostMapping("/customert/update")
	public String customerUpdate(@Validated @ModelAttribute CustomerDetailForm form, BindingResult result, @ModelAttribute CustomerSearchForm form1, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 顧客画面のヴァリデーションチェック
		if(result.hasErrors()) {
			model.addAttribute("prefs", prefRepository.findAll());
			model.addAttribute("type", "update");
			model.addAttribute("label", "更新");
			return "customer_detail";
		}
		// 契約タイプのチェック
//		Long[] type = form.getContractType();
//		if(type.length == 0) {
//			model.addAttribute("prefs", prefRepository.findAll());
//			model.addAttribute("errs", "契約タイプを選択してください。");
//			return "contract_detail";
//		}
		// 更新対象データの取得
//		try {
			Customer customer = customerRepository.findById(form.getId());
			Timestamp now = new Timestamp(System.currentTimeMillis());
			Integer userId = (Integer)this.session.getAttribute("userId");
			customer.setContractId(form.getContractId());
			customer.setCustomerName(form.getCustomerName());
			customer.setCustomerKana(form.getCustomerKana());
			customer.setZip(form.getZip());
			customer.setPrefCd(form.getPref());
			customer.setCity(form.getCity());
			customer.setAddress(form.getAddress());
			customer.setOtherAddress(form.getOtherAddress());
			customer.setBirthday(form.getBirthday());
			customer.setEmail(form.getEmail());
			customer.setPhoneNo(form.getPhoneNo());
			customer.setFaxNo(form.getFaxNo());
			customer.setMobilePhone(form.getMobilePhone());
			customer.setUpdateDate(now);
			customer.setUpdateUser(userId);
			customerRepository.save(customer);
			// 契約リンク削除
//			List<ContractLink> contractLinks = contractLinkRepository.findByContractId(form.getId());
//			for(ContractLink contractLink: contractLinks) {
//				contractLinkRepository.deleteById(contractLink.getId());
//			}
//			// 更新契約リンク登録
//			Arrays.stream(type).forEach(s -> {
//				ContractLink contractLink = new ContractLink();
//				contractLink.setContractId(form.getId());
//				contractLink.setContractTypeId(s);
//				contractLinkRepository.save(contractLink);
//			});
//		} catch (DataAccessException e){
//			e.printStackTrace();
//		}
		// 顧客一覧表示
		model.addAttribute("customers", customerRepository.findByContractIdAndDeleteDateIsNullOrderByCustomerKana(form.getContractId()));
		return "customer_list";
	}

	@GetMapping("/customer/destroy/{key}")
	public String customerDestroy(@PathVariable("key") String key, @ModelAttribute CustomerDetailForm form, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
		// 顧客削除画面の設定
		Long id = Long.parseLong(key);
		Customer customer = customerRepository.findById(id);
		form.setId(customer.getId());
		form.setContractId(customer.getContractId());
		form.setCustomerName(customer.getCustomerName());
		form.setCustomerKana(customer.getCustomerKana());
		form.setZip(customer.getZip());
		form.setPref(customer.getPrefCd());
		form.setCity(customer.getCity());
		form.setAddress(customer.getAddress());
		form.setOtherAddress(customer.getOtherAddress());
		form.setBirthday(customer.getBirthday());
		form.setEmail(customer.getEmail());
		form.setPhoneNo(customer.getPhoneNo());
		form.setFaxNo(customer.getFaxNo());
		form.setMobilePhone(customer.getMobilePhone());
		form.setMemo(customer.getMemo());
		model.addAttribute("prefs", prefRepository.findAll());
		model.addAttribute("type", "delete");
		model.addAttribute("label", "削除");
//		model.addAttribute("contractKey", contract.getContractKey());
		return "customer_detail";
	}

	@PostMapping("/customer/delete")
	public String customerDelete(@ModelAttribute CustomerDetailForm form, @ModelAttribute CustomerSearchForm form1, Model model) {
		if(this.session.getAttribute("contractKey") == null) {
			return "login/";
		}
//		try {
//			String key = form.getContractKey();
			// 登録ユーザ削除
//			List<User> users = userRepository.findByContractKey(key);
//			for(User user: users) {
//				userRepository.deleteById(user.getId());
//			}
//			Contract contract = contractRepository.findByContractKeyAndDeleteDateIsNull(key);
			// 契約リンク削除
//			System.out.println("ID1=" + form.getId());
//			List<ContractLink> contractLinks = contractLinkRepository.findByContractId(form.getId());
//			System.out.println("Loop Start");
//			for(ContractLink contractLinkd: contractLinks) {
//				System.out.println("ID2=" + contractLinkd.getId());
//				contractLinkRepository.deleteById(contractLinkd.getId());
//			};
		// 顧客情報の削除
		Customer customer = customerRepository.findById(form.getId());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Integer userId = (Integer)this.session.getAttribute("userId");
		customer.setDeleteDate(now);
		customer.setDeleteUser(userId);
		customerRepository.save(customer);
//		}catch (DataAccessException e) {
//			e.printStackTrace();
//		}
		model.addAttribute("customers", customerRepository.findByContractIdAndDeleteDateIsNullOrderByCustomerKana(form.getContractId()));
		return "customer_list";
	}
}
