package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

    private final ImageUploadService imageUploadService;


    @Autowired
    public ImageUploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping
    public String uploadImage(@RequestParam String filePath) {
        try {
            return "Uploaded image: " + imageUploadService.uploadImage(filePath);
        } catch (IOException e) {
            return "Upload error: " + e.getMessage();
        }
    }
}
