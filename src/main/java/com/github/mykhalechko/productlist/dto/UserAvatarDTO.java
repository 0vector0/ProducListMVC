package com.github.mykhalechko.productlist.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserAvatarDTO {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
