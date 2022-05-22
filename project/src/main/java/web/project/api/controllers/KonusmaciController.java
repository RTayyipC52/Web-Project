package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.KonusmaciService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Konusmaci;

import java.util.List;

@RestController
@RequestMapping("/api/Konusmaci")
@CrossOrigin

public class KonusmaciController {

    private KonusmaciService konusmaciService;

    @Autowired
    public  KonusmaciController(KonusmaciService konusmaciService){
        this.konusmaciService = konusmaciService;
    }

    @GetMapping("/getAllKonusmaci")
    public DataResult<List<Konusmaci>> getAll() {
        return this.konusmaciService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Konusmaci> getById(@RequestParam int konusmaciId) {
        return this.konusmaciService.getById(konusmaciId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Konusmaci konusmaci) {
        return this.konusmaciService.add(konusmaci);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Konusmaci konusmaci) {
        return this.konusmaciService.update((konusmaci));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int konusmaciId) {
        return this.konusmaciService.delete(konusmaciId);
    }
}