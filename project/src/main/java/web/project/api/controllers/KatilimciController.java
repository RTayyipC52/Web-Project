package web.project.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.project.business.abstracts.KatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Katilimci;
import web.project.entities.dtos.KatilimciRegisterDto;

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
    public DataResult<Katilimci> getById(@RequestParam int katilimciId) {
        return this.katilimciService.getById(katilimciId);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Katilimci katilimci) {
        return this.katilimciService.update((katilimci));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int katilimciId) {
        return this.katilimciService.delete(katilimciId);
    }
    
    @GetMapping("/getByUser_UserId")
    public DataResult<Katilimci> getByUser_UserId(@RequestParam int userId) {
        return this.katilimciService.getByUser_UserId(userId);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KatilimciRegisterDto katilimciRegisterDto){
        Result result=this.katilimciService.add(katilimciRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}