package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.EtkinlikService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.dtos.AddEtkinlikDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/Etkinlik")

public class EtkinlikController {

    private EtkinlikService etkinlikService;

    @Autowired
    public EtkinlikController(EtkinlikService etkinlikService) {
        this.etkinlikService = etkinlikService;
    }

    @GetMapping("/getAllEtkinlik")
    public DataResult<List<Etkinlik>> getAll() {
        return this.etkinlikService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Etkinlik> getById(@RequestParam int etkinlikId) {
        return this.etkinlikService.getById(etkinlikId);
    }
	/*
	 * @PostMapping("/add") public Result add(@RequestBody Etkinlik etkinlik) {
	 * return this.etkinlikService.add(etkinlik); }
	 */
    @PutMapping("/update")
    public Result update(@RequestBody Etkinlik etkinlik){
        return this.etkinlikService.update((etkinlik));
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int etkinlikId){
        return this.etkinlikService.delete(etkinlikId);
    }
    
    @GetMapping("/getBySertifikaImage_SertifikaImageId")
    public DataResult<List<Etkinlik>> getBySertifikaImage_SertifikaImageId(@RequestParam int sertifikaImageId) {
        return this.etkinlikService.getBySertifikaImage_SertifikaImageId(sertifikaImageId);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddEtkinlikDto addEtkinlikDto){
        Result result=this.etkinlikService.add(addEtkinlikDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}