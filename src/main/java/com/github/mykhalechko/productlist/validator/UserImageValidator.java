package com.github.mykhalechko.productlist.validator;

import com.github.mykhalechko.productlist.dto.UserAvatarDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

@Component
public class UserImageValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserAvatarDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserAvatarDTO profileImage = (UserAvatarDTO) target;
        validateFileType(errors, profileImage);
        validateForMinMaxFileSize(errors, profileImage);

    }

    private void validateForMinMaxFileSize(Errors errors, UserAvatarDTO userImage) {
        if (userImage.getFile().getSize() == 0) {
            errors.reject("image.empty");
        }
        if (userImage.getFile().getSize() > 10) {
            errors.reject("image.too.large");
        }
    }

    private void validateFileType(Errors errors, UserAvatarDTO userImage) {
        try (InputStream input = userImage.getFile().getInputStream()) {
            try {
                ImageIO.read(input);
            } catch (Exception e) {
                errors.reject("image.empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
