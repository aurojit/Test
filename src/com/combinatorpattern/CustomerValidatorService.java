package com.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public boolean isPhoneValid(String phone) {
        return phone.startsWith("+");
    }

    public boolean isDOBValid(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }
}
