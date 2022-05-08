package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.KatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

import web.project.entities.concretes.Katilimci;

import java.util.List;

@RestController
@RequestMapping("/api/Katilimci")
@CrossOrigin

public class KatilimciController{

    private KatilimciService katilimciService;

    @Autowired
    public  KatilimciController(KatilimciService katilimciService){
        this.katilimciService = katilimciService;
    }

    @GetMapping("/getAllKatilimcilar")
    public DataResult<List<Katilimci>> getAll() {
        return this.katilimciService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Katilimci> getById(@RequestParam int id) {
        return this.katilimciService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Katilimci katilimci) {
        return this.katilimciService.add(katilimci);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Katilimci katilimci) {
        return this.katilimciService.update((katilimci));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.katilimciService.delete(id);
    }
}