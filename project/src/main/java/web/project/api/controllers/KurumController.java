package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.KurumService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Kurum;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/Kurum")

public class KurumController {

    private KurumService kurumService;

    @Autowired
    public KurumController(KurumService kurumService) {
        this.kurumService = kurumService;
    }

    @GetMapping("/getAllKurum")
    public DataResult<List<Kurum>> getAll() {
        return this.kurumService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Kurum> getById(@RequestParam int kurum_id) {
        return this.kurumService.getById(kurum_id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Kurum kurum )  {
        return this.kurumService.add(kurum);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Kurum kurum){
        return this.kurumService.update((kurum));
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int kurum_id){
        return this.kurumService.delete(kurum_id);
    }
}