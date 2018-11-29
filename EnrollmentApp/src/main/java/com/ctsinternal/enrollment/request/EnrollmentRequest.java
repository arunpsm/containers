package com.ctsinternal.enrollment.request;

import java.util.Date;

public class EnrollmentRequest {

	private int customerId;
	private String customerName;
	private String customerDoB;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerDoB() {
		return customerDoB;
	}

	public void setCustomerDoB(String customerDoB) {
		this.customerDoB = customerDoB;
	}
}
