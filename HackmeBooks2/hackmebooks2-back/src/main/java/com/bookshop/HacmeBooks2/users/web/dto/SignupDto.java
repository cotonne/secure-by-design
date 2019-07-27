package com.bookshop.HacmeBooks2.users.web.dto;


import com.bookshop.HacmeBooks2.users.model.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch(first = "password", second = "password_confirmation", message = "The password fields must match")
public class SignupDto {
    @NotEmpty
    public String username;
    @NotEmpty
    public String password;
    @NotEmpty
    public String password_confirmation;
    @NotEmpty
    public String first_name;
    @NotEmpty
    public String last_name;
    @NotEmpty
    @Email
    public String email;
    public String phone_number;
    public String ssn;
    @NotEmpty
    public String password_hint;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword_hint() {
        return password_hint;
    }

    public void setPassword_hint(String password_hint) {
        this.password_hint = password_hint;
    }
}
