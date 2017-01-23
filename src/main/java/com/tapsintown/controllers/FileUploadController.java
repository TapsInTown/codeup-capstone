package com.tapsintown.controllers;

import com.tapsintown.interfaces.EventImages;
import com.tapsintown.interfaces.Events;
import com.tapsintown.models.Event;
import com.tapsintown.models.EventImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by anthonyfortney on 1/19/17.
 */
@Controller
public class  FileUploadController {

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    private EventImages eventImgDao;

    @Autowired
    private Events eventDao;

    @PostMapping("/fileupload/{id}")
    public String saveFile(
            @RequestParam(name = "file") MultipartFile uploadedFile,
            @PathVariable long id,
            Model model
    ) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        EventImage eventImage = new EventImage();

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }

        Event event = eventDao.findOne(id);
        eventImage.setEvent(event);
        eventImage.setImageUrl(filename);

        eventImgDao.save(eventImage);

        return "redirect:/events/" + id + "/edit";
    }
}