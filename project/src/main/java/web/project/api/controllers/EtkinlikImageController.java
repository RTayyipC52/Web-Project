package web.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import web.project.business.abstracts.EtkinlikImageService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.EtkinlikImage;

@RestController
@RequestMapping("api/EtkinlikImages")
@CrossOrigin
public class EtkinlikImageController {
	private EtkinlikImageService etkinlikImageService;

    @Autowired
    public EtkinlikImageController(EtkinlikImageService etkinlikImageService) {
        this.etkinlikImageService = etkinlikImageService;
    }
    
    @GetMapping("/getAll")
    public DataResult<List<EtkinlikImage>> getAll() {
        return this.etkinlikImageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<EtkinlikImage> getById(@RequestParam int etkinlik_image_id) {
        return this.etkinlikImageService.getById(etkinlik_image_id);
    }
    
    @PostMapping("/upload")
    public Result upload(@RequestParam int etkinlik_id, @RequestPart("file") MultipartFile file) {
        return this.etkinlikImageService.upload(etkinlik_id, file);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int etkinlik_image_id) {
        return etkinlikImageService.delete(etkinlik_image_id);
    }
}
