package com.ctsinternal.enrollment.controller;

import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctsinternal.enrollment.request.EnrollmentRequest;
import com.ctsinternal.enrollment.response.EnrollmentBaseResponse;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {

	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int CODE_FAILURE = 404;

	private final String sharedKey = "SHARED_KEY_SECRET";

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public EnrollmentBaseResponse enrollCustomer(@RequestParam(value = "key") String key,
			@RequestBody EnrollmentRequest request) {
		EnrollmentBaseResponse response = new EnrollmentBaseResponse();
		if (!sharedKey.equalsIgnoreCase(key)) {
			response.setStatus(ERROR_STATUS);
			response.setCode(CODE_FAILURE);
		} else {
			int customerId = request.getCustomerId();
			String customerName = request.getCustomerName();
			String dob = request.getCustomerDoB();

			// Process the request
			Logger logger = Logger.getLogger(EnrollmentController.class.getName());
			logger.info("customerId = " + customerId + "; customerName = " + customerName + "; customerDoB = " + dob);

			// Return success response to the client.
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
		}
		return response;
	}

}
