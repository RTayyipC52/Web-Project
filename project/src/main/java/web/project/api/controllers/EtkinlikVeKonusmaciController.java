package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.EtkinlikVeKonusmaciService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

import web.project.entities.concretes.EtkinlikVeKonusmaci;

import java.util.List;

@RestController
@RequestMapping("/api/EtkinlikVeKonusmacilar")
@CrossOrigin

public class EtkinlikVeKonusmaciController {

    private EtkinlikVeKonusmaciService etkinlikVeKonusmaciService;

    @Autowired
    public  EtkinlikVeKonusmaciController(EtkinlikVeKonusmaciService etkinlikVeKonusmaciService){
        this.etkinlikVeKonusmaciService = etkinlikVeKonusmaciService;
    }

    @GetMapping("/getAllEtkinlikVeKonusmacilar")
    public DataResult<List<EtkinlikVeKonusmaci>> getAll() {
        return this.etkinlikVeKonusmaciService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<EtkinlikVeKonusmaci> getById(@RequestParam int etkinlik_konusmaci_id) {
        return this.etkinlikVeKonusmaciService.getById(etkinlik_konusmaci_id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
        return this.etkinlikVeKonusmaciService.add(etkinlikVeKonusmaci);
    }

    @PostMapping("/update")
    public Result update(@RequestBody EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
        return this.etkinlikVeKonusmaciService.update((etkinlikVeKonusmaci));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int etkinlik_konusmaci_id) {
        return this.etkinlikVeKonusmaciService.delete(etkinlik_konusmaci_id);
    }
}
