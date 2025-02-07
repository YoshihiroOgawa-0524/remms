package jp.co.remms.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class ContractSearchForm {
	
	@Size(max = 16)
	private String searchKey;

	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate fromLimit;
	private LocalDate toLimit;

	@Size(max = 64)
	private String searchName;

	@Size(max = 64)
	private String searchKana;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LocalDate getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(LocalDate fromLimit) {
		this.fromLimit = fromLimit;
	}

	public LocalDate getToLimit() {
		return toLimit;
	}

	public void setToLimit(LocalDate toLimit) {
		this.toLimit = toLimit;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchKana() {
		return searchKana;
	}

	public void setSearchKana(String searchKana) {
		this.searchKana = searchKana;
	}
}
