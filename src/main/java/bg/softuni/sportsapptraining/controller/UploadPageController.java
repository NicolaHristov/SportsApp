package bg.softuni.sportsapptraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadPageController {

    @GetMapping("/upload-form")
    public String showUploadForm() {
        return "upload";
    }
}
