package com.github.mykhalechko.productlist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return MultipartFile.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MultipartFile file = (MultipartFile) o;
        if (file.isEmpty() || file.getSize() == 0)
            errors.rejectValue("file", "image.empty");

        if (!(file.getContentType().toLowerCase().equals("image/jpg")
                || file.getContentType().toLowerCase().equals("image/jpeg")
                || file.getContentType().toLowerCase().equals("image/gif")
                || file.getContentType().toLowerCase().equals("image/png"))) {
            errors.rejectValue("file", "not.image");
        }
    }
}
