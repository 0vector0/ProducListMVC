package com.github.mykhalechko.productlist.validator;

import com.github.mykhalechko.productlist.model.User;
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


    @Value("${size.userForm.username}")
    private String sizeUsername;
    // TODO: 29.01.2017 use another filed from validation.properties

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 2 || user.getUsername().length() > 32) {
            System.out.println(sizeUsername);
            errors.rejectValue("username", sizeUsername);
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println("Duplicate.userForm.username");
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            System.out.println("Size.userForm.password");
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            System.out.println("Diff.userForm.passwordConfirm");
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}