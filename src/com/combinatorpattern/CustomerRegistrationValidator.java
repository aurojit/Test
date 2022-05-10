package com.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import com.combinatorpattern.CustomerRegistrationValidator.ValidationResults;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResults> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? ValidationResults.SUCCESS : ValidationResults.INVALID_EMAIL;
    }

    static CustomerRegistrationValidator isPhoneValid() {
        return customer -> customer.getPhone().startsWith("+") ? ValidationResults.SUCCESS : ValidationResults.INVALID_PHONE;
    }

    static CustomerRegistrationValidator isDOBValid() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? ValidationResults.SUCCESS : ValidationResults.INVALID_DOB;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResults result = this.apply(customer);
            return result.equals(ValidationResults.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResults {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE,
        INVALID_DOB
    }
}
