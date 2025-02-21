package jp.co.remms.form;

public class CustomerSearchForm {
	
	private String searchName;
	private String searchKana;
	private String searchAddress;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String customerName) {
		this.searchName = customerName;
	}

	public String getSearchKana() {
		return searchKana;
	}

	public void setSearchKana(String customerKana) {
		this.searchKana = customerKana;
	}

	public String getSearchAddress() {
		return searchAddress;
	}

	public void setSearchAddress(String contactAddress) {
		this.searchAddress = contactAddress;
	}
}
