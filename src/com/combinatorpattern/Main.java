package com.combinatorpattern;

import com.combinatorpattern.CustomerRegistrationValidator.ValidationResults;

import java.time.LocalDate;

import static com.combinatorpattern.CustomerRegistrationValidator.isDOBValid;
import static com.combinatorpattern.CustomerRegistrationValidator.isEmailValid;
import static com.combinatorpattern.CustomerRegistrationValidator.isPhoneValid;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "aa@d.com", "+99232", LocalDate.of(2000, 1, 1));

        ValidationResults result = isEmailValid()
                .and(isPhoneValid())
                .and(isDOBValid())
                .apply(customer);

        System.out.println(result);



    }
}
