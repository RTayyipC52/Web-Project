package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.EtkinlikVeKatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.EtkinlikVeKatilimci;

import java.util.List;

@RestController
@RequestMapping("/api/EtkinlikVeKatilimcilar")
@CrossOrigin

public class EtkinlikVeKatilimciController {

    private EtkinlikVeKatilimciService etkinlikVeKatilimciService;

    @Autowired
    public  EtkinlikVeKatilimciController(EtkinlikVeKatilimciService etkinlikVeKatilimciService){
        this.etkinlikVeKatilimciService = etkinlikVeKatilimciService;
    }

    @GetMapping("/getAllEtkinlikVeKatilimcilar")
    public DataResult<List<EtkinlikVeKatilimci>> getAll() {
        return this.etkinlikVeKatilimciService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<EtkinlikVeKatilimci> getById(@RequestParam int id) {
        return this.etkinlikVeKatilimciService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EtkinlikVeKatilimci etkinlikVeKatilimci) {
        return this.etkinlikVeKatilimciService.add(etkinlikVeKatilimci);
    }

    @PostMapping("/update")
    public Result update(@RequestBody EtkinlikVeKatilimci etkinlikVeKatilimci) {
        return this.etkinlikVeKatilimciService.update((etkinlikVeKatilimci));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.etkinlikVeKatilimciService.delete(id);
    }
}