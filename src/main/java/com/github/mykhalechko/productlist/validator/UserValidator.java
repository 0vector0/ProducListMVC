package com.github.mykhalechko.productlist.validator;

import com.github.mykhalechko.productlist.entity.User;
import com.github.mykhalechko.productlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Value("${userForm.username}")
    private String username;

    @Value("${userForm.email}")
    private String email;

    @Value("${userForm.password}")
    private String password;

    @Value("${userForm.passwordConfirm}")
    private String passwordConfirm;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 2 || user.getUsername().length() > 32) {
            System.out.println(username);
            errors.rejectValue("username", username);
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println(username);
            errors.rejectValue("username", username);
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            System.out.println(email);
            errors.rejectValue("email", email);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            System.out.println(password);
            errors.rejectValue("password", password);
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            System.out.println(passwordConfirm);
            errors.rejectValue("passwordConfirm", passwordConfirm);
        }
    }
}