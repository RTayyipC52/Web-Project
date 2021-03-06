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

import web.project.business.abstracts.SertifikaImageService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.SertifikaImage;

@RestController
@RequestMapping("api/SertifikaImages")
@CrossOrigin
public class SertifikaImageController {
	private SertifikaImageService sertifikaImageService;

    @Autowired
    public SertifikaImageController(SertifikaImageService sertifikaImageService) {
        this.sertifikaImageService = sertifikaImageService;
    }
    
    @GetMapping("/getAll")
    public DataResult<List<SertifikaImage>> getAll() {
        return this.sertifikaImageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<SertifikaImage> getById(@RequestParam int sertifikaImageId) {
        return this.sertifikaImageService.getById(sertifikaImageId);
    }
    
    @PostMapping("/upload")
    public Result upload(@RequestParam int sertifikaId, @RequestPart("file") MultipartFile file) {
        return this.sertifikaImageService.upload(sertifikaId, file);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int sertifikaImageId) {
        return sertifikaImageService.delete(sertifikaImageId);
    }
    
    @GetMapping("/getBySertifikaId")
    public DataResult<SertifikaImage> getBySertifika_SertifikaId(@RequestParam int sertifikaId) {
        return this.sertifikaImageService.getBySertifika_SertifikaId(sertifikaId);
    }
}
