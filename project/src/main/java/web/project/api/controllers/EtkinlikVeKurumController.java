package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.EtkinlikVeKurumService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.EtkinlikVeKurum;

import java.util.List;

@RestController
@RequestMapping("/api/EtkinlikVeKurumlar")
@CrossOrigin

public class EtkinlikVeKurumController {

    private EtkinlikVeKurumService etkinlikVeKurumService;

    @Autowired
    public  EtkinlikVeKurumController(EtkinlikVeKurumService etkinlikVeKurumService){
        this.etkinlikVeKurumService = etkinlikVeKurumService;
    }

    @GetMapping("/getAllEtkinlikVeKurumlar")
    public DataResult<List<EtkinlikVeKurum>> getAll() {
        return this.etkinlikVeKurumService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<EtkinlikVeKurum> getById(@RequestParam int etkinlik_kurum_id) {
        return this.etkinlikVeKurumService.getById(etkinlik_kurum_id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EtkinlikVeKurum etkinlikVeKurum) {
        return this.etkinlikVeKurumService.add(etkinlikVeKurum);
    }

    @PostMapping("/update")
    public Result update(@RequestBody EtkinlikVeKurum etkinlikVeKurum) {
        return this.etkinlikVeKurumService.update((etkinlikVeKurum));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int etkinlik_kurum_id) {
        return this.etkinlikVeKurumService.delete(etkinlik_kurum_id);
    }
}