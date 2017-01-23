package com.github.mykhalechko.productlist.validator;

import com.github.mykhalechko.productlist.dto.UserImageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

@Component
public class UserImageValidator implements Validator {

    @Value("${user.image.upload.size}")
    private Long imageMaxSize;

    @Value("${user.image.empty}")
    private String imageEmpty;

    @Value("${user.image.not.image}")
    private String notImage;

    @Value("${user.image.too.large}")
    private String imageToLarge;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserImageDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserImageDTO profileImage = (UserImageDTO) target;
        validateFileType(errors, profileImage);
        validateForMinMaxFileSize(errors, profileImage);

    }

    private void validateForMinMaxFileSize(Errors errors, UserImageDTO userImage) {
        if (userImage.getFile().getSize() == 0) {
            errors.reject(imageEmpty);
            System.out.println(imageEmpty);
        }
        if (userImage.getFile().getSize() > imageMaxSize) {
            errors.reject(imageToLarge);
            System.out.println(imageToLarge);
        }
    }

    private void validateFileType(Errors errors, UserImageDTO userImage) {
        try (InputStream input = userImage.getFile().getInputStream()) {
            try {
                ImageIO.read(input);
            } catch (Exception e) {
                errors.reject(notImage);
                System.out.println(notImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
