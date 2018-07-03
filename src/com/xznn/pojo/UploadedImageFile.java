package com.xznn.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {

    /*
    这里的字段 image必须和上传页面upload.jsp中的image
    <input type="file" name="image" accept="image/*" />
    保持一致
    */
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
