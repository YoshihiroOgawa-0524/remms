package jp.co.remms.form;

public class CustomerSearchForm {
	
	private String customerName;
	private String customerKana;
	private String contactAddress;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerKana() {
		return customerKana;
	}

	public void setCustomerKana(String customerKana) {
		this.customerKana = customerKana;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
}
