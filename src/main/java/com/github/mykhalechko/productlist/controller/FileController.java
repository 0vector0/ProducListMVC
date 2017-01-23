package com.github.mykhalechko.productlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileController {

    //    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public
//    @ResponseBody
//    String handleFileUpload(@RequestParam("filename") String filename,
//                            @RequestParam("file") MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream =
////                        new BufferedOutputStream(new FileOutputStream(new File("d:/yourApplicationName/" + filename)));
//                        new BufferedOutputStream(new FileOutputStream(new File("public/images/" + filename)));
//                stream.write(bytes);
//                stream.close();
////                return "You successfully uploaded " + filename + " into " + filename + "-uploaded !";
//                return "redirect:/uploadSuccess";
//            } catch (Exception e) {
//                return "You failed to upload " + filename + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + filename + " because the file was empty.";
//        }
//    }
    public static final String uploadingdir = System.getProperty("user.dir") + "/image/";

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String getFile() {

        return "file";
    }


    @RequestMapping(value = "image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File(uploadingdir + imageName + ".png");

        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value = "/uploadSuccess", method = RequestMethod.GET)
    public String getUploadSuccess() {
        return "uploadSuccess";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("file") MultipartFile uploadingFile) throws IOException {


        File file = new File(uploadingdir + uploadingFile.getOriginalFilename());
        uploadingFile.transferTo(file);


        return "redirect:/uploadSuccess";
    }

}
