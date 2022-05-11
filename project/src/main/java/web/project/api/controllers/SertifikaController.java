package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.SertifikaService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Sertifika;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/Sertifika")

public class SertifikaController {

    private SertifikaService sertifikaService;

    @Autowired
    public SertifikaController(SertifikaService sertifikaService) {
        this.sertifikaService = sertifikaService;
    }

    @GetMapping("/getAllSertifika")
    public DataResult<List<Sertifika>> getAll() {
        return this.sertifikaService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Sertifika> getById(@RequestParam int sertifikaId) {
        return this.sertifikaService.getById(sertifikaId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Sertifika sertifika )  {
        return this.sertifikaService.add(sertifika);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Sertifika sertifika){
        return this.sertifikaService.update((sertifika));
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int sertifikaId){
        return this.sertifikaService.delete(sertifikaId);
    }
}