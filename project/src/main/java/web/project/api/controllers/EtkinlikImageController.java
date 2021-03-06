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
    public DataResult<EtkinlikImage> getById(@RequestParam int etkinlikImageId) {
        return this.etkinlikImageService.getById(etkinlikImageId);
    }
    
    @PostMapping("/upload")
    public Result upload(@RequestParam int etkinlikId, @RequestPart("file") MultipartFile file) {
        return this.etkinlikImageService.upload(etkinlikId, file);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int etkinlikImageId) {
        return etkinlikImageService.delete(etkinlikImageId);
    }
    
    @GetMapping("/getByEtkinlikId")
    public DataResult<EtkinlikImage> getByEtkinlik_EtkinlikId(@RequestParam int etkinlikId) {
        return this.etkinlikImageService.getByEtkinlik_EtkinlikId(etkinlikId);
    }
}
