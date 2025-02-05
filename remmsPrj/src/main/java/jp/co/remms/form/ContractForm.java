package jp.co.remms.form;

import java.time.LocalDate;

public class ContractForm {
	private String searchKey;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate fromLimit;
	private LocalDate toLimit;
	private String searchName;
	private String searchKana;
	private Integer id;
	private String key;
	private LocalDate date;
	private String name;
	private String kana;
	private String zip;
	private String pref;
	private String city;
	private String address;
	private String otherAddress;
	private String tel;
	private String email;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String search_key) {
		this.searchKey = search_key;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate from_date) {
		this.fromDate = from_date;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate to_date) {
		this.toDate = to_date;
	}

	public LocalDate getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(LocalDate from_limit) {
		this.fromLimit = from_limit;
	}

	public LocalDate getToLimit() {
		return toLimit;
	}

	public void setToLimit(LocalDate to_limit) {
		this.toLimit = to_limit;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String search_name) {
		this.searchName = search_name;
	}

	public String getSearchKana() {
		return searchKana;
	}

	public void setSearchKana(String search_kana) {
		this.searchName = search_kana;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
